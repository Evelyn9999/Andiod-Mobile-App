package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.json.Json.Default.configuration
import java.util.*


@Composable
fun HomePage(navController: NavHostController) {
    var selectedLanguage by remember { mutableStateOf("English") }
    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    val image = painterResource(R.drawable.finlandmap)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = "Map of Finland",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        var dropdownExpanded by remember { mutableStateOf(false) }

        Box(modifier = Modifier.padding(16.dp)) {

            TextButton(onClick = {
                // Toggle between English and Finnish
                selectedLanguage = if (selectedLanguage == "en") "fi" else "en"
                val locale = Locale(selectedLanguage)
                context.resources.configuration.setLocale(locale)
                context.resources.updateConfiguration(context.resources.configuration, context.resources.displayMetrics)
            }, modifier = Modifier.padding(16.dp).align(Alignment.TopStart)) {
                Text(text = if (selectedLanguage == "en") "English" else "Suomi")
            }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
            ){
            Text(
                stringResource(R.string.WELCOME),
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                stringResource(R.string.FINNISH_LEARNER),
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
                    Text(stringResource(R.string.Listening), fontSize = 15.sp, color = Color.DarkGray)
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
                    Text(stringResource(R.string.Speaking), fontSize = 15.sp, color = Color.DarkGray)
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
                    Text(stringResource(R.string.Reading), fontSize = 15.sp, color = Color.DarkGray)
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
                    Text(stringResource(R.string.Writing),
                        fontSize = 15.sp,
                        color = Color.DarkGray)
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
                Text(stringResource(R.string.More_info_about_Finland), fontSize = 15.sp, color = Color.DarkGray)
            }
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