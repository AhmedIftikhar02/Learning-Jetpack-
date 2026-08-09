package com.example.learingjetpack.lesson03

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun RecompositionDemoPreview() {
    RecompositionDemo()
}

@Composable
private fun RecompositionDemo() {
    var count by remember {
        mutableStateOf(0)
    }

    var name by remember {
        mutableStateOf("Ahmed")
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CounterText(count)
        NameText(name)

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Increment")

        }

        Button(
            onClick = {
                if (name == "Ahmed"){
                    name = "Ali"
                }else{
                    name = "Ahmed"
                }
            }
        ) {
            Text("Change Name")

        }
    }
}



@Composable
private fun CounterText(count: Int) {
    Text(
        text = "Count: $count"
    )
}

@Composable
private fun NameText(name: String) {
    Text(
        text = "Name: $name"
    )
}


@Composable
private fun ParentScreen() {

    var showCounter by remember {
        mutableStateOf(true)
    }

    Column {

        Button(
            onClick = {
                showCounter = !showCounter
            }
        ) {
            Text("Show / Hide Counter")
        }

        if (showCounter) {
            RememberDemo()
        }
    }
}

@Composable
private fun RememberDemo() {

    var count by remember {
        mutableStateOf(0)
    }

    Column {

        Text(
            text = "Count: $count"
        )

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Increment")
        }
    }
}



@Composable
private fun SaveableDemo() {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Name: $name"
        )

        Button(
            onClick = {
                name = if (name.isEmpty()) {
                    "Ahmed"
                } else {
                    ""
                }
            }
        ) {
            Text("Change Name")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun DerivedStateDemo() {
    
    var firstName by remember {
        mutableStateOf("Ahmed")
    }

    var lastName by remember {
        mutableStateOf("Iftikhar")
    }

    val fullName by remember {
        derivedStateOf {
            "$firstName $lastName"
        }
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Name: $fullName")

        Button(
            onClick = {
                firstName = if (firstName == "Ahmed"){
                    "Ali"
                }else{
                    "Ahmed"
                }
            }
        ) {

            Text("Change First Name")
        }


        Button(
            onClick = {
                lastName = if (lastName == "Iftikhar"){
                    "Khan"
                }else{
                    "Iftikhar"
                }
            }
        ) {

            Text("Change Last Name")
        }

    }
    
}