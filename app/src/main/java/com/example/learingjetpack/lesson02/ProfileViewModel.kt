package com.example.learingjetpack.lesson02

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class ProfileUiState(
    val name: String = "Ahmed Iftikhar",
    val role: String = "Android Developer",
    val isFollowing: Boolean = false
)

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> = _uiState

    fun onFollowClick() {
        _uiState.update {
            it.copy(
                isFollowing = !it.isFollowing
            )
        }
    }
}