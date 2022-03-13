package com.example.adoptame.data.api.service

import com.example.adoptame.data.api.entidades.newsApi.RestaurantsApiEntity
import retrofit2.Response
import retrofit2.http.*

interface RestaurantsService {

    @GET("/restaurants")
    suspend fun getAllRestaurants():
            Response<RestaurantsApiEntity>


}