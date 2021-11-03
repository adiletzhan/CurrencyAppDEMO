package com.example.currencyappdemo.apiData

import retrofit2.http.GET

const val BASE_URL = "https://hiring.revolut.codes/api/android"

interface ApiRequest {

    @GET("/latest")
    suspend fun getLatestCurrency(): CurrencyData

}