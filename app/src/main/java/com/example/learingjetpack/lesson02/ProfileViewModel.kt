package com.example.learingjetpack.lesson02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

data class ProfileUiState(
    val name: String = "Ahmed Iftikhar",
    val role: String = "Android Developer",
    val followers: Int = 120,
    val isFollowing: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed interface ProfileEvent {
    data object FollowClicked : ProfileEvent
    data object RetryClicked : ProfileEvent
}

sealed interface ProfileEffect {
    data class ShowSnackbar(val message: String) : ProfileEffect
}

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    private val _effect = Channel<ProfileEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: ProfileEvent) {
        when (event) {
            ProfileEvent.FollowClicked -> handleFollowClicked()
            ProfileEvent.RetryClicked -> handleRetryClicked()
        }
    }

    private fun handleFollowClicked() {
        if (_uiState.value.isLoading) return

        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            delay(1000)

            val currentState = _uiState.value
            val willFollow = !currentState.isFollowing

            val newFollowerCount = if (willFollow) {
                currentState.followers + 1
            } else {
                currentState.followers - 1
            }

            _uiState.update {
                it.copy(
                    isFollowing = willFollow,
                    followers = newFollowerCount,
                    isLoading = false
                )
            }

            val message = if (willFollow) {
                "Followed successfully!"
            } else {
                "Unfollowed"
            }

            _effect.send(
                ProfileEffect.ShowSnackbar(message)
            )
        }
    }

    private fun handleRetryClicked() {
        // Later
    }
}