package com.example.learingjetpack.lesson02

sealed interface ProfileEvent {
    data class FollowClicked(val profileId: String) : ProfileEvent
    data object RetryClicked : ProfileEvent
}