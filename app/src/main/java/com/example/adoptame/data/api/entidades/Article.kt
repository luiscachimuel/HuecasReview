package com.example.adoptame.data.api.entidades

import com.example.adoptame.database.entidades.ReviewsEntity

data class Restaurant(
    val id: Int,
    val Nombre: String,
    val Categoria: String,
    val Direccion: String,
    val Review: String,
    val Rating: Double,
    val Imagen: String,
    val Coordenada: String
)

fun Restaurant.toReviewEntity() = ReviewsEntity(id, Nombre, Categoria, Review, Rating, Imagen, Coordenada)