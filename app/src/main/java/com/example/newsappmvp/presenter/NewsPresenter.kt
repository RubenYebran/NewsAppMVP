package com.example.newsappmvp.presenter

import com.example.newsappmvp.contract.NewsContract
import com.example.newsappmvp.data.model.Article
import com.example.newsappmvp.data.remote.NewsDataSource
import com.example.newsappmvp.repository.NewsAPI
import com.example.newsappmvp.repository.NewsRepositoryImpl
import com.example.newsappmvp.view.ui.news.NewsFragment

class NewsPresenter(context: NewsFragment) : NewsContract.NewsPresenter {

    private val newsView = context as NewsContract.NewsView

    val model = NewsRepositoryImpl(NewsDataSource(NewsAPI.RetrofitNewsList.webService))

    override fun getDataFromApi() {
        model.getDataFromApi(this)
    }

    override suspend fun onSucess(list: List<Article>?){
        list?.let {
            newsView.onDataCompleteFromApi(it)
        }
    }

    override fun onFail(){
        newsView.onDataErrorFromApi(Throwable("Error"))
    }
}


