package com.example.shortnewsapp.com.example.shortnewsapp.data.api

import com.example.shortnewsapp.com.example.shortnewsapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "YOUR_ACTUAL_API_KEY"
    ) : Response<NewsResponse>
}

//https://newsapi.org/v2/top-headlines?country=us&apiKey=b06a31d1d09b437a9c8514183e4fd6d9