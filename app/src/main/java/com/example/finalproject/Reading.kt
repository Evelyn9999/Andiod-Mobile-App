package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


data class NewsItem(val title: String, val imageUrl: Int, val summary: String)
@Composable
fun Reading(navController: NavHostController) {
    val newsList: List<NewsItem> = listOf(
        // Populate with your actual data
        NewsItem("Jääkiekko",
            R.drawable.reading1,
            "Kommentti: Tapparan esimerkki voi ratkaista Suomi-kiekon suurimman ongelman"),
        NewsItem("Rikosepäilyt",
            R.drawable.reading2,
            "Analyysi: Timo Vornanen ampui kohti perussuomalaisten ydinasioita"),
        NewsItem("Jääkiekko",
            R.drawable.reading3,
            "Yle näyttää suorana: Tappara juhlii kultaa Tampereen Keskustorilla maanantaina"),
        NewsItem("Politiikka",
            R.drawable.reading4,
            "Timo Vornanen jää kahden viikon sairauslomalle")
    )

    // provide a URI handler to open a web page
    val uriHandler = LocalUriHandler.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ) {
        Row( modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Button(
                onClick = { navController.navigate("HomePage") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x6666EB76),
                ),
            ) {
                Text(text = "👈", fontSize = 15.sp, color = Color.DarkGray)
            }

            OutlinedButton(
                onClick = {
                    uriHandler.openUri("https://yle.fi/uutiset/paauutiset")
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Click and Visit YLE News")
            }
        }


        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(newsList) { news ->
                NewsCard(news)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }


    }
}

@Composable
fun NewsCard(newsItem: NewsItem) {
    // Implement your news card design here
    Column {
        Text(text = newsItem.title, fontWeight = FontWeight.SemiBold)

        // This will load and display your image
        Image(
            painter = painterResource(id = newsItem.imageUrl),
            contentDescription = newsItem.title // Provide a description for accessibility
        )

        Text(text = newsItem.summary)
    }
}

@Preview(showBackground = true)
@Composable
fun ReadingPreview(){
    val navController = rememberNavController()
    Reading(navController)
}