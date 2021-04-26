package com.example.newsappmvp.repository

import com.example.newsappmvp.application.AppConstants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPI {
    object RetrofitNewsList {
        val webService: RetrofitService by lazy {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .build().create(RetrofitService::class.java)
        }
    }
}