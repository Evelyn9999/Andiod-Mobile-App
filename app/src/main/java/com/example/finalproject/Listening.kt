package com.example.finalproject

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Listening(navController: NavHostController) {
    Text("Listening", fontSize = 20.sp)
}

@Preview
@Composable
fun ListeningPreview(){
    val navController = rememberNavController()
    Listening(navController)
}