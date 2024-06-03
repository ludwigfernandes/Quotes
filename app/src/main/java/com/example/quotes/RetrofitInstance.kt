package com.example.quotes

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL_QUOTE = "https://zenquotes.io/api/"
    val apiQuote: QuoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_QUOTE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApiService::class.java)
    }


    private const val BASE_URL_PHOTO="https://api.unsplash.com/"

    private  val loggingInterceptor=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient=OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val apiPhoto: QuoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_PHOTO)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApiService::class.java)
    }
}