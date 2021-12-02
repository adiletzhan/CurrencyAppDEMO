package com.example.currencyappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.currencyappdemo.apiData.ApiRequest
import com.example.currencyappdemo.apiData.CurrencyData
import com.example.currencyappdemo.apiData.RetrofitInstance
import com.example.currencyappdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: ApiRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(ApiRequest::class.java)

        var data: Response<CurrencyData> = loadData()

        binding.tvItem1.text = data.body()?.baseCurrency

    }

//    private fun loadData(): Response<CurrencyData> = RetrofitInstance.api.getLatestCurrency()
    private fun loadData(): Response<CurrencyData> = retService.getLatestCurrency()

}