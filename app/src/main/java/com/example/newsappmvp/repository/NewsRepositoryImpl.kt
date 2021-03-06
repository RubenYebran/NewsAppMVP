package com.example.newsappmvp.repository

import com.example.newsappmvp.data.model.NewsList
import com.example.newsappmvp.data.remote.NewsDataSource
import com.example.newsappmvp.presenter.NewsPresenter
import kotlinx.coroutines.*
import retrofit2.Response


class NewsRepositoryImpl(private val dataSource: NewsDataSource) : NewsRepository {

    override suspend fun getNews(): Response<NewsList> = dataSource.getNews()

    override fun getDataFromApi(newsPresenter: NewsPresenter) {
        CoroutineScope(Dispatchers.IO).launch{
            if (getNews().isSuccessful) {
                getNews().body()?.let {
                    newsPresenter.onSuccess(it.articles)
                }
            } else {
                newsPresenter.onFail(Throwable("Error"))
            }
        }
    }
   /* override fun getDataFromApi(newsPresenter: NewsPresenter) {
        GlobalScope.launch(Dispatchers.IO) {
            try{
                getNews().body()?.let {
                    newsPresenter.onSuccess(it.articles)
                }
            }catch (e: Exception){
                newsPresenter.onFail(e)
            }
        }
    }*/
}