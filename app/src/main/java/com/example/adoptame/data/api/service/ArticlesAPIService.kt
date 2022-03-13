package com.example.adoptame.data.api.service

import com.example.adoptame.data.api.entidades.RestaurantsApiEntity
import retrofit2.Response
import retrofit2.http.GET

interface ArticlesAPIService {

    @GET("/restaurants")
    suspend fun getAllNewsByCountryAndCategory(
    ): Response<RestaurantsApiEntity>

}