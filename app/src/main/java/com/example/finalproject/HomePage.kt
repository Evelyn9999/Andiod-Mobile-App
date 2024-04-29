package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
            contentScale = ContentScale.FillBounds,
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
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                // Button Listening
                Button(
                    onClick = { navController.navigate("Listening") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x66E9819B),
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    Text(text = "Listening", fontSize = 15.sp, color = Color.DarkGray)
                }

                // Button Speaking
                Button(
                    onClick = { navController.navigate("Speaking") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x8FFFEB3B),
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    Text(text = "Speaking", fontSize = 15.sp, color = Color.DarkGray)
                }
            }

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                // Button Reading
                Button(
                    onClick = { navController.navigate("Reading") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x6666EB76),
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    Text(text = "Reading", fontSize = 15.sp, color = Color.DarkGray)
                }

                // Button Writing
                Button(
                    onClick = { navController.navigate("Writing") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x6F2197F7),
                    ),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)

                ) {
                    Text(text = "Writing", fontSize = 15.sp, color = Color.DarkGray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("MoreInfo") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x52673AB7)
                ),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = "More info about Finland...", fontSize = 15.sp, color = Color.DarkGray)
            }
        }
    }
}


@Preview
@Composable
fun HomePagePreview(){
    val navController = rememberNavController()
    HomePage(navController)
}