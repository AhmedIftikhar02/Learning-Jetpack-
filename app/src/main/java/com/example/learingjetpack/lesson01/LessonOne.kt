package com.example.learingjetpack.lesson01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.learingjetpack.lesson02.ProfileEffect
import com.example.learingjetpack.lesson02.ProfileEvent
import com.example.learingjetpack.lesson02.ProfileUiState
import com.example.learingjetpack.lesson02.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ProfileEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = effect.message)
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ProfileCard(
                uiState = uiState,
                onFollowClick = {
                    viewModel.onEvent(ProfileEvent.FollowClicked)
                }
            )
        }
    }
}

@Composable
fun ProfileCard(
    uiState: ProfileUiState,
    onFollowClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Profile")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = uiState.name)
            Text(text = uiState.role)
        }

        Text(text = "${uiState.followers} followers")

        Button(
            onClick = onFollowClick,
            enabled = !uiState.isLoading,
            modifier = Modifier.align(Alignment.End)
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(
                    text = if (uiState.isFollowing) "Following" else "Follow"
                )
            }
        }
    }
}