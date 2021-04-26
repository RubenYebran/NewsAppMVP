package com.example.newsappmvp.repository
import com.example.newsappmvp.data.model.NewsList
import com.example.newsappmvp.presenter.NewsPresenter
import retrofit2.Response

interface NewsRepository {
     suspend fun getNews(): Response<NewsList>
     fun getDataFromApi(newsPresenter: NewsPresenter)
}