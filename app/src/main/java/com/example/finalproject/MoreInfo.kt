package com.example.finalproject

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.*
import kotlinx.serialization.json.*


@Composable
fun MoreInfo(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    var apiData by remember { mutableStateOf("Loading data...") }

    LaunchedEffect(Unit) {
        scope.launch {
            apiData = fetchApiData()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text("More about Finland...", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(apiData, fontSize = 18.sp) // Displaying the API data
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("HomePage") }) {
            Text(text = "Back", fontSize = 20.sp)
        }
    }
}

suspend fun fetchApiData(): String = withContext(Dispatchers.IO) {
    try {
        val url = URL("https://pxdata.stat.fi/PXWeb/api/v1/en/StatFin")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            return@withContext inputStream.bufferedReader().readText()
        }
    } catch (e: Exception) {
        return@withContext "Failed to load data: ${e.message}"
    }
}

@Preview(showBackground = true)
@Composable
fun MoreInfoPreview(){
    val navController = rememberNavController()
    MoreInfo(navController)
}