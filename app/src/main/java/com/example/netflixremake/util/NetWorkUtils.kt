package com.example.netflixremake.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertPath

class NetWorkUtils {

    companion object{


       fun getinstance(path: String): Retrofit {
           return Retrofit.Builder().baseUrl(path)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
       }
    }
}