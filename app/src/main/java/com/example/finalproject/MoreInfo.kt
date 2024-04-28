package com.example.finalproject

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun MoreInfo(navController: NavHostController) {
    Text("More about Finland...", fontSize = 10.sp)
}

@Preview
@Composable
fun MoreInfoPreview(){
    val navController = rememberNavController()
    MoreInfo(navController)
}