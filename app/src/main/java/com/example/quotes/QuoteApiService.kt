package com.example.quotes

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApiService {

    @GET("quotes")
    suspend fun getQuotes(): Response<List<Quote>>

    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Photo>
}