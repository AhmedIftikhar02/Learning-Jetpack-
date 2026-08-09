package com.example.learingjetpack.lesson02

// Pure Domain Model
data class Profile(
    val id: String,
    val name: String,
    val role: String,
    val followers: Int,
    val isFollowing: Boolean = false
)

// UI Wrapper for item-level UI state
data class ProfileItemUiState(
    val profile: Profile,
    val isLoading: Boolean = false
)

// Screen list state
sealed interface ProfileListUiState {
    data object Loading : ProfileListUiState
    data class Success(val profiles: List<ProfileItemUiState>) : ProfileListUiState
    data object Empty : ProfileListUiState
    data class Error(val message: String) : ProfileListUiState
}

// Overall screen state
data class ProfileUiState(
    val profileState: ProfileListUiState = ProfileListUiState.Loading
)