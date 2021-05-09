package com.example.newsappmvp.data.model

import com.google.gson.annotations.SerializedName

data class gSource(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)