package com.example.newsappmvp.repository

import com.example.newsappmvp.data.model.NewsList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("everything")
    suspend fun getNews(@Query("q") q: String,
                        @Query("apiKey") apiKey: String
    ): Response<NewsList>

}

