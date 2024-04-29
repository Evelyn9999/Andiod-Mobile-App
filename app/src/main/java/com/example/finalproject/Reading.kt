package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource


data class NewsItem(val title: String, val imageUrl: Int, val summary: String)
@Composable
fun Reading(navController: NavHostController) {
    val newsList: List<NewsItem> = listOf(
        // Populate with actual data
        NewsItem("Kommentti: Tapparan esimerkki voi ratkaista Suomi-kiekon suurimman ongelman",
            R.drawable.reading1,
            "Jääkiekko 28/04/2024"),
        NewsItem("Analyysi: Timo Vornanen ampui kohti perussuomalaisten ydinasioita",
            R.drawable.reading2,
            "Rikosepäilyt 28/04/2024"),
        NewsItem("Yle näyttää suorana: Tappara juhlii kultaa Tampereen Keskustorilla maanantaina",
            R.drawable.reading3,
            "Jääkiekko 28/04/2024"),
        NewsItem("Timo Vornanen jää kahden viikon sairauslomalle",
            R.drawable.reading4,
            "28/04/2024"),
        NewsItem("Täyteainehoitoja voi tehdä käytännössä kuka tahansa",
            R.drawable.reading5,
            "Kuva: Juha Kivioja / Yle 28/04/2024"),
        NewsItem("Toisen maailmansodan aikaista ponttoonia nostetaan merenpohjasta Kotkassa",
            R.drawable.reading6,
            "Kuva: Kalle Purhonen / Yle 28/04/2024"),
        NewsItem("Skotlannin pääministeri eroaa",
            R.drawable.reading7,
            "Kuva: EPA-EFE 28/04/2024"),

    )

    // provide a URI handler to open a web page
    val uriHandler = LocalUriHandler.current

    Column(modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { navController.navigate("HomePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x6666EB76),
            ),
        ) {
            Text(text = "BACK", fontSize = 15.sp, color = Color.DarkGray)
        }

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(newsList) { news ->
                NewsCard(news)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        OutlinedButton(
            onClick = {
                uriHandler.openUri("https://yle.fi/uutiset/paauutiset")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text("Click and Visit YLE News")
        }
    }
}

@Composable
fun NewsCard(newsItem: NewsItem) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = newsItem.imageUrl),
            contentDescription = newsItem.title, // Provide a description for accessibility
            modifier = Modifier
                .size(80.dp) // Fixed size for the image
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between image and text

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = newsItem.title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                text = newsItem.summary,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReadingPreview(){
    val navController = rememberNavController()
    Reading(navController)
}
