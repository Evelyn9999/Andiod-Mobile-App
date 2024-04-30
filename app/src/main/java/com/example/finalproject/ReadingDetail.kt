package com.example.finalproject

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Modifier

@Composable
fun ReadingDetail(navController: NavHostController) {
    Text("Building Details Here")
    Button(onClick = { navController.navigate("Speaking") }) {
        Text("Back")
    }
}

@Preview
@Composable
fun ReadingDetailPreview(){
    val navController = rememberNavController()
    ReadingDetail(navController)
}