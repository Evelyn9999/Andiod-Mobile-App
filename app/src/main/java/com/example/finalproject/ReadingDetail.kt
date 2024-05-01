package com.example.finalproject

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ReadingDetail(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start // Align the title to start
        ) {
            // Back button
            Button(onClick = { navController.navigateUp() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x8FFFEB3B),
                ),) {
                Text(stringResource(R.string.BACK), color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.height(26.dp))
            // Title for the dialog
            Text("kahvilassa",
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally))

            Spacer(modifier = Modifier.height(26.dp))
            // Voice bars
            val voiceBarCount = 7
            for (i in 1..voiceBarCount) {
                ConversationVoiceBar(isEven = i % 2 == 0)
            }
        }
    }
}

@Composable
fun ConversationVoiceBar(isEven: Boolean) {
    val circleSize = 30.dp // New size for the circle
    val barHeight = 30.dp  // New height for the bar to make it thicker
    val barWidth = 180.dp  // Width for the bars remains the same

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Increased padding for more space
        horizontalArrangement = if (isEven) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isEven) { // For odd, circle is on the left side of the bar.
            Canvas(modifier = Modifier.size(circleSize), onDraw = {
                drawCircle(color = Color.LightGray, radius = size.minDimension / 2)
            })
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .height(barHeight)
                    .width(barWidth)
                    .background(color = Color.LightGray)
            )
        }
        if (isEven) { // For even, circle is on the right side of the bar.
            Box(
                modifier = Modifier
                    .height(barHeight)
                    .width(barWidth)
                    .background(color = Color(0x8FFFEB3B))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Canvas(modifier = Modifier.size(circleSize), onDraw = {
                drawCircle(color = Color(0x8FFFEB3B), radius = size.minDimension / 2)
            })
        }
    }
}



@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ReadingDetailPreview() {
    Surface(color = Color.White) {
        val navController = rememberNavController() // Mock NavController for Preview
        ReadingDetail(navController)
    }
}
