package com.example.learingjetpack.lesson02

interface ProfileRepository {

    suspend fun getProfiles(): Result<List<Profile>>

    suspend fun toggleFollow(profileId: String): Result<Profile>
}