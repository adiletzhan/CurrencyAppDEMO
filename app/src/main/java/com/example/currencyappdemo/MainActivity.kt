package com.example.currencyappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.currencyappdemo.apiData.CurrencyData
import com.example.currencyappdemo.apiData.RetrofitInstance
import com.example.currencyappdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        var data: CurrencyData = loadData()
        binding.tvItem1.text =

    }

    private fun loadData(): CurrencyData {

        GlobalScope.launch(Dispatchers.IO) {
            val response = try {
                RetrofitInstance.api.getLatestCurrency()
            } catch (e: Exception) {
                Log.e("Main", "Error: ${e.message}")
            }

            return response
        }
    }
}