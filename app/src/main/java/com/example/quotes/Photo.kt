package com.example.quotes

data class Photo(
    val id: String,
    val urls: Urls
)

data class Urls(
    val small: String,
    val regular: String
)