package com.example.learingjetpack.lesson02

sealed interface ProfileEffect {
    data class ShowSnackbar(val message: String) : ProfileEffect
}