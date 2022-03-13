package com.example.adoptame.logica

import com.example.adoptame.casosUso.ReviewsUseCase
import com.example.adoptame.database.entidades.ReviewsEntity

class RevewsBL() {

    suspend fun getNewsList(category: String, page: Int): List<ReviewsEntity> {
        return ReviewsUseCase().getAllRestaurantsApi()
    }

    suspend fun checkIsSaved(id: Int): Boolean {
        val n = ReviewsUseCase().getOneNews(id)
        return (n != null)
    }

    suspend fun getFavoritesNews(): List<ReviewsEntity> {
        return ReviewsUseCase().getFavoritesNews()
    }

    suspend fun saveNewFavNews(reviews: ReviewsEntity) {
        ReviewsUseCase().saveNewFavNews(reviews)
    }

    suspend fun deleteNewFavNews(reviews: ReviewsEntity) {
        ReviewsUseCase().deleteNewFavNews(reviews)
    }

}