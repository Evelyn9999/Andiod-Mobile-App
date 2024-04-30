package com.example.finalproject

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



@Composable
fun MoreInfo(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text("More about Finland...", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("HomePage") }) {
            Text(text = "Back", fontSize = 20.sp)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MoreInfoPreview(){
    val navController = rememberNavController()
    MoreInfo(navController)
}