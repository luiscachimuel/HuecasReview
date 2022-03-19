package com.example.adoptame.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    fun getRestaurantsApi(): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.100.138:9095/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}