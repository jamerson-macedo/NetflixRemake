package com.example.netflixremake.model

import com.google.gson.annotations.SerializedName

data class ModelCSItem(
    @SerializedName("contains")
    val contains: List<Contain>,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    var name: String
)