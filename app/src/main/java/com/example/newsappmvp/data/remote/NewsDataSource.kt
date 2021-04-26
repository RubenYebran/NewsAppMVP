package com.example.newsappmvp.data.remote

import com.example.newsappmvp.application.AppConstants
import com.example.newsappmvp.data.model.NewsList
import com.example.newsappmvp.repository.RetrofitService
import retrofit2.Response

class NewsDataSource(private val webService: RetrofitService) {
     suspend fun getNews(): Response<NewsList> = webService.getNews(AppConstants.QUERY, AppConstants.API_KEY)
}
