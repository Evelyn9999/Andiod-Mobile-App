package com.example.finalproject

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun MoreInfo(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    var apiData by remember { mutableStateOf("Loading data...") }

    // Use LaunchedEffect to fetch data when the composable enters the composition
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                apiData = fetchDataFromApi("https://pxdata.stat.fi/PXWeb/api/v1/en/StatFin")
            } catch (e: Exception) {
                apiData = "Failed to load data: ${e.message}"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Button(
            onClick = { navController.navigate("HomePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x66E9819B),
            ),
        ) {
            Text(text = "BACK", fontSize = 15.sp, color = Color.DarkGray)
        }

        Spacer(modifier = Modifier.height(16.dp))
        MapView(modifier = Modifier.fillMaxSize().height(120.dp))

        Spacer(modifier = Modifier.height(16.dp))
        Text("Statistics Finland's online service",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(16.dp))
        Text(apiData, fontSize = 12.sp)  // Displaying the API data

    }
}


@Preview(showBackground = true)
@Composable
fun MoreInfoPreview(){
    val navController = rememberNavController()
    MoreInfo(navController)
}