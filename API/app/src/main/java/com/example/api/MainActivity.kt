package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is success, the use the data in your app and show it on your app
                val responseBody = response.body()
                val productList = responseBody?.products!!

                val collectDataInSB = StringBuilder()

                for (myData in productList){
                    collectDataInSB.append(myData.title + " ")
                }

                val tV = findViewById<TextView>(R.id.textView)
                tV.text = collectDataInSB
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // if api call fails
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}