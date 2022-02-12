package com.example.adoptame.logica

import com.example.adoptame.casosUso.ReviewsUseCase
import com.example.adoptame.database.entidades.Reviews

class ReviewsBL {

    fun getNewsList(): List<Reviews> {
        Thread.sleep(2000)
        return ReviewsUseCase().getAllNews()
    }

    fun getOneNews(): Reviews {
        val r = (0..3).random()
        return ReviewsUseCase().getAllNews()[r]
    }

    suspend fun checkIsSaved(id: Int): Boolean {
        val n = ReviewsUseCase().getOneNews(id)
        return (n != null)
    }

    suspend fun getFavoritesNews(): List<Reviews> {
        return ReviewsUseCase().getFavoritesNews()
    }

    suspend fun saveNewFavNews(news: Reviews) {
        ReviewsUseCase().saveNewFavNews(news)
    }

    suspend fun deleteNewFavNews(news: Reviews) {
        ReviewsUseCase().deleteNewFavNews(news)
    }

}