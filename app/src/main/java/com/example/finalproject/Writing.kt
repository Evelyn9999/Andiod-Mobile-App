package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Writing(navController: NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text("Writing", fontSize = 20.sp)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray))
            Button(onClick = { navController.navigate("HomePage") }) {
                Text(text = "Back to HomePage", fontSize = 20.sp)
            }
        }

}

@Preview(showBackground = true)
@Composable
fun WritingPreview(){
    val navController = rememberNavController()
    Writing(navController)
}