package com.example.finalproject

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Writing(navController: NavHostController) {
    Text("Writing", fontSize = 20.sp)
}

@Preview
@Composable
fun WritingPreview(){
    val navController = rememberNavController()
    Writing(navController)
}