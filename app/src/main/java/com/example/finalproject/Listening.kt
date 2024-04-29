package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon




@Composable
fun Listening(navController: NavHostController) {

    var playing by remember { mutableStateOf(false) }
    var audioSpeed by remember { mutableFloatStateOf(1f) }
    val speeds = listOf(0.5f, 0.75f, 1f, 1.25f, 1.5f)
    val audioText = "Paragraph text here..." // Replace with your actual text
    // Placeholders for audio playback logic
    // val audioPlayer = remember { YourAudioPlayer() }

    Column(modifier = Modifier.padding(16.dp)) {
        // Back to home page button
        Button(
            onClick = { navController.navigate("HomePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x66E9819B),
            ),
        ) {
            Text(text = "BACK", fontSize = 15.sp, color = Color.DarkGray)
        }

        Spacer(modifier = Modifier.height(8.dp) )

        // This box represents the text area for the paragraph
        Box(
            modifier = Modifier
                .background(color = Color(0x2CE6D2D8))
                .fillMaxWidth()
                .weight(1f)
                .border(1.dp, Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = audioText, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            // Speed selection button
            Button(onClick = {
                val currentIndex = speeds.indexOf(audioSpeed)
                audioSpeed = speeds[(currentIndex + 1) % speeds.size]
                // audioPlayer.setSpeed(audioSpeed)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x66E9819B),
                ),
                ) {
                Text("x$audioSpeed", fontSize = 12.sp, color = Color.DarkGray)
            }

            // Playback controls
            PlaybackControls(
                playing = playing,
                onPlayPauseClicked = {
                    playing = !playing
                    // audioPlayer.playOrPause()
                },
                onNextClicked = {
                    // audioPlayer.next()
                },
                onPreviousClicked = {
                    // audioPlayer.previous()
                }
            )

            // Navigation to history audios
            Button(
                onClick = { /* Navigate to history audios list */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x66E9819B),
                ),
                ) {
                Text("List", fontSize = 15.sp, color = Color.DarkGray)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Placeholder for "Upload your audio..." button
        OutlinedButton(
            onClick = { /* Open upload functionality */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
            ) {
            Text("Upload your own audio...")
        }


    }
}

// A separate composable for playback controls for better organization
@Composable
fun PlaybackControls(
    playing: Boolean,
    onPlayPauseClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onPreviousClicked) {
            Icon(Icons.Default.SkipPrevious,
                contentDescription = "Previous")
        }
        IconButton(onClick = onPlayPauseClicked) {
            Icon(if (playing) Icons.Default.Pause else Icons.Default.PlayArrow,
                contentDescription = if (playing) "Pause" else "Play")
        }
        IconButton(onClick = onNextClicked) {
            Icon(Icons.Default.SkipNext,
                contentDescription = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListeningPreview(){
    val navController = rememberNavController()
    Listening(navController)
}