package com.example.learingjetpack.lesson01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Learning Jetpack Compose"
        )

        Text(
            text = "My first Compose application"
        )

        Button(
            onClick = {}
        ) {
            Text("Get Started")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ProfileCard(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Profile"
        )
        Text(
            text = "Profile"
        )
        Text(
            text = "Profile"
        )
        Button(onClick = {}) {
            Text("Follow")
        }

    }
}