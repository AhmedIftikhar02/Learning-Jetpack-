package com.example.learingjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.learingjetpack.lesson01.ProfileScreen
import com.example.learingjetpack.lesson02.ProfileViewModel
import com.example.learingjetpack.ui.theme.LearingJetpackTheme

class MainActivity : ComponentActivity() {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearingJetpackTheme {
                ProfileScreen(viewModel = profileViewModel)
            }
        }
    }
}