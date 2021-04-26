package com.example.newsappmvp.data.model

import com.google.gson.annotations.SerializedName

class NewsList(
    @SerializedName("articles")
    val articles: List<Article> = listOf()
)
