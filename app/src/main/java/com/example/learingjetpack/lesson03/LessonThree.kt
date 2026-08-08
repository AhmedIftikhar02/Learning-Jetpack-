package com.example.learingjetpack.lesson03

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ProProfile() {

    Card(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(10.dp),

            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("A")
                }

                Spacer(modifier = Modifier.size(10.dp))

                Column() {
                    Text("Ahmed Iftikhar", style = MaterialTheme.typography.titleMedium)
                    Text("Android Dev")
                }
            }

            Text("Folowers")

            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Follow")
            }
        }
    }

}