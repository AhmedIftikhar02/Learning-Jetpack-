package com.example.learingjetpack.lesson02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    private val _effect = Channel<ProfileEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        loadProfiles()
    }

    private fun loadProfiles() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    profileState = ProfileListUiState.Loading
                )
            }

            val result = repository.getProfiles()

            result
                .onSuccess { profiles ->

                    val items = profiles.map { profile ->
                        ProfileItemUiState(
                            profile = profile
                        )
                    }

                    _uiState.update {
                        it.copy(
                            profileState = if (items.isEmpty()) {
                                ProfileListUiState.Empty
                            } else {
                                ProfileListUiState.Success(items)
                            }
                        )
                    }
                }
                .onFailure { throwable ->

                    _uiState.update {
                        it.copy(
                            profileState = ProfileListUiState.Error(
                                message = throwable.message
                                    ?: "Something went wrong"
                            )
                        )
                    }
                }
        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.FollowClicked -> handleFollowClicked(event.profileId)
            ProfileEvent.RetryClicked -> handleRetryClicked()
        }
    }

    private fun handleFollowClicked(profileId: String) {

        val currentState = _uiState.value.profileState

        if (currentState !is ProfileListUiState.Success) {
            return
        }

        viewModelScope.launch {

            _uiState.update { state ->

                val updatedItems = currentState.profiles.map { item ->

                    if (item.profile.id == profileId) {
                        item.copy(isLoading = true)
                    } else {
                        item
                    }
                }

                state.copy(
                    profileState = ProfileListUiState.Success(
                        updatedItems
                    )
                )
            }

            val result = repository.toggleFollow(profileId)

            result
                .onSuccess { updatedProfile ->

                    _uiState.update { state ->

                        val currentItems =
                            (state.profileState as? ProfileListUiState.Success)
                                ?.profiles
                                ?: return@update state

                        val updatedItems = currentItems.map { item ->

                            if (item.profile.id == profileId) {

                                item.copy(
                                    profile = updatedProfile,
                                    isLoading = false
                                )

                            } else {
                                item
                            }
                        }

                        state.copy(
                            profileState = ProfileListUiState.Success(
                                updatedItems
                            )
                        )
                    }

                    val message =
                        if (updatedProfile.isFollowing) {
                            "Followed ${updatedProfile.name}!"
                        } else {
                            "Unfollowed ${updatedProfile.name}"
                        }

                    _effect.send(
                        ProfileEffect.ShowSnackbar(message)
                    )
                }

                .onFailure { throwable ->

                    _uiState.update { state ->

                        val currentItems =
                            (state.profileState as? ProfileListUiState.Success)
                                ?.profiles
                                ?: return@update state

                        val updatedItems = currentItems.map { item ->

                            if (item.profile.id == profileId) {
                                item.copy(isLoading = false)
                            } else {
                                item
                            }
                        }

                        state.copy(
                            profileState = ProfileListUiState.Success(
                                updatedItems
                            )
                        )
                    }

                    _effect.send(
                        ProfileEffect.ShowSnackbar(
                            throwable.message ?: "Failed to update profile"
                        )
                    )
                }
        }
    }

    private fun handleRetryClicked() {
        loadProfiles()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ProfileViewModel(FakeProfileRepository())
            }
        }
    }
}