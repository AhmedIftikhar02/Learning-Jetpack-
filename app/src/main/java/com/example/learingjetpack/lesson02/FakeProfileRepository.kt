package com.example.learingjetpack.lesson02

import kotlinx.coroutines.delay

class FakeProfileRepository : ProfileRepository {

    private val profiles = mutableListOf(
        Profile(
            id = "1",
            name = "Ahmed Iftikhar",
            role = "Android Developer",
            followers = 120
        ),
        Profile(
            id = "2",
            name = "Ali Khan",
            role = "Kotlin Developer",
            followers = 540
        ),
        Profile(
            id = "3",
            name = "Hassan Ahmed",
            role = "Backend Engineer",
            followers = 890
        ),
        Profile(
            id = "4",
            name = "Usman Raza",
            role = "UI/UX Designer",
            followers = 310
        )
    )

    override suspend fun getProfiles(): Result<List<Profile>> {
        delay(1000)

        return Result.success(profiles.toList())
    }

    override suspend fun toggleFollow(
        profileId: String
    ): Result<Profile> {

        delay(1000)

        val index = profiles.indexOfFirst {
            it.id == profileId
        }

        if (index == -1) {
            return Result.failure(
                IllegalArgumentException("Profile not found")
            )
        }

        val current = profiles[index]

        val updated = current.copy(
            isFollowing = !current.isFollowing,
            followers = if (current.isFollowing) {
                current.followers - 1
            } else {
                current.followers + 1
            }
        )

        profiles[index] = updated

        return Result.success(updated)
    }
}