package com.example.netflixremake.util

import com.example.netflixremake.model.ModelCS
import com.example.netflixremake.model.ModelCSItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("en/collections.json")
    fun getall(): Call<List<ModelCSItem>>
}