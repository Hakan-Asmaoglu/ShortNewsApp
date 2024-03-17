package com.example.shortnewsapp.com.example.shortnewsapp.data.datasource

import com.example.shortnewsapp.com.example.shortnewsapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(country: String): Response<NewsResponse>
}