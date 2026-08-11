package com.example.learingjetpack.lesson04

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
private fun ModifierDemo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Ahmed",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Continue")
        }



        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            Text("Box 1")
        }

        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .size(150.dp)
        ) {
            Text("Box 2 ")
        }

        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Text("Box 3")
        }

    }

}

@Composable
private fun WeightDemo() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Cyan)
        ){
            Text("Box 1")
        }

        Box(
            modifier = Modifier
                .weight(2f)
                .height(100.dp)
                .background(Color.Red)
        ){
            Text("Box 2")
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .background(Color.Blue)
        )
        {
            Text("Box 3")
        }
    }
}


@Composable
fun AlignmentExperimentScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "First Item",
            color = Color.Black
        )
        Text(
            text = "Second Item",
            color = Color.Gray
        )
        Text(
            text = "Third Item",
            color = Color.DarkGray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(top = 24.dp)
                .background(Color.LightGray.copy(alpha = 0.3f)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Magenta),
                contentAlignment = Alignment.Center
            ) {
                Text("1", color = Color.White)
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("2", color = Color.White)
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text("3", color = Color.White)
            }
        }
    }
}



@Composable
private fun Alignment() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Start",
            modifier = Modifier.align(Alignment.Start)
        )

        Text(
            text = "Center",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "End",
            modifier = Modifier.align(Alignment.End)
        )

        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Continue")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun Box() {

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Gray)
            .padding(12.dp)
    ) {

        Text(
            text = "Top Start",
            modifier = Modifier.align(Alignment.TopStart)
        )

        Text(
            text = "Top End",
            modifier = Modifier.align(Alignment.TopEnd)
        )

        Text(
            text = "Center",
            modifier = Modifier.align(Alignment.Center)
        )

        Text(
            text = "Bottom End",
            modifier = Modifier.align(Alignment.BottomEnd)
        )


    }

}