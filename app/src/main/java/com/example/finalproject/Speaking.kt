package com.example.finalproject

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun <MediaPlayer> Speaking(navController: NavHostController) {

    val image = painterResource(R.drawable.speaking)
    var iconPosition by remember { mutableStateOf(Offset.Unspecified) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = "Map of Finland",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { offset ->
                            // Update the iconPosition with the offset where the user tapped
                            iconPosition = offset
                            // Navigate to the building details page when a building is clicked
                            navController.navigate("ReadingDetail")
                        }
                    )
                }
        )

        if (iconPosition != Offset.Unspecified) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val path = Path().apply {
                    moveTo(iconPosition.x, iconPosition.y - 30) // Top of the pin
                    lineTo(iconPosition.x - 15, iconPosition.y) // Left bottom corner of the pin head
                    lineTo(iconPosition.x, iconPosition.y + 30) // Bottom of the pin body
                    lineTo(iconPosition.x + 15, iconPosition.y) // Right bottom corner of the pin head
                    close()
                }
                drawPath(path, color = Color.Black)
            }
        }

        Button(
            onClick = { navController.navigate("HomePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x8FFFEB3B),
            ),
        ) {
            Text(text = "BACK", fontSize = 15.sp, color = Color.DarkGray)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SpeakingPreview(){
    val navController = rememberNavController()
    Speaking<Any>(navController)
}