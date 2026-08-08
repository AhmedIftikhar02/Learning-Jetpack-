package com.example.learingjetpack.lesson01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.learingjetpack.lesson02.ProfileUiState
import com.example.learingjetpack.lesson02.ProfileViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    ProfileCard(
        uiState = uiState,
        onFollowClick = viewModel::onFollowClick

    )
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

        Button(
            onClick = onFollowClick,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(
                text = if (uiState.isFollowing) "Following" else "Follow"
            )
        }
    }
}