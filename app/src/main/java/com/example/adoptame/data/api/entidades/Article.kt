package com.example.adoptame.data.api.entidades

import com.example.adoptame.database.entidades.ReviewsEntity

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun Article.toNewsEntity() = ReviewsEntity(0, author, title, description, urlToImage)