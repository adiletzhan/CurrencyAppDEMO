package com.example.currencyappdemo.apiData

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://hiring.revolut.codes/api/android/"

object RetrofitInstance {

    fun getRetrofitInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
/*
    val api: ApiRequest by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://hiring.revolut.codes/api/android/")
           // .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiRequest::class.java)
    }


 */
}