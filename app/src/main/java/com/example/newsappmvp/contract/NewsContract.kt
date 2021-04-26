package com.example.newsappmvp.contract

import com.example.newsappmvp.data.model.Article

interface NewsContract {

    interface NewsPresenter{
        fun getDataFromApi()
        suspend fun onSucess(list: List<Article>?)
        fun onFail()
    }

    interface NewsView {
        fun onDataCompleteFromApi(newsList: List<Article>)
        fun onDataErrorFromApi(throwable: Throwable)
        fun onArticleClick(article: Article)
    }

    interface NewsDetail {
        fun showData()
    }

}