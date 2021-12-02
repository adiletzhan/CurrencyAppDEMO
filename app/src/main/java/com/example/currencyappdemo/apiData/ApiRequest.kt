package com.example.currencyappdemo.apiData

import retrofit2.Response
import retrofit2.http.GET


interface ApiRequest {

    @GET("/latest?base=EUR")
    fun getLatestCurrency(): Response<CurrencyData>

}