package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomePage(navController: NavHostController) {
    val image = painterResource(R.drawable.finlandmap)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = "Map of Finland",
            contentScale = ContentScale.Crop, // or ContentScale.Fit
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
            ){
            Text(
                text = "WELCOME!",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "FINNISH LEARNER",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Listening(navController)
            Speaking(navController)
            Reading(navController)
            Writing(navController)
            Spacer(modifier = Modifier.height(16.dp))
            MoreInfo(navController)
        }
    }
}

@Preview
@Composable
fun HomePagePreview(){
    val navController = rememberNavController()
    HomePage(navController)
}