package com.example.finalproject

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

// Setup the HTTP Client
val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

// Example function to fetch data
suspend fun fetchDataFromApi(url: String): String {
    return client.get(url)
}


