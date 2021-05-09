package com.example.newsappmvp.contract

import com.example.newsappmvp.data.model.Article

interface NewsContract {

    interface NewsPresenter {
        fun getDataFromApi()
        fun onSuccess(list: List<Article>)
        fun onFail(t: Throwable)
    }

    interface NewsView {
        fun onDataCompleteFromApi(newsList: List<Article>)
        fun onDataErrorFromApi(t: Throwable)
        fun onArticleClick(article: Article)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface NewsDetail {
        fun showData()
    }

}