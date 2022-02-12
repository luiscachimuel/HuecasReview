package com.example.adoptame.controladores

import com.example.adoptame.database.entidades.Reviews
import com.example.adoptame.logica.ReviewsBL

class ReviewController {

    fun getOneNews(): Reviews {
        return ReviewsBL().getOneNews()
    }

    suspend fun checkIsSaved(id:Int): Boolean {
        return ReviewsBL().checkIsSaved(id)
    }

    suspend fun saveFavNews(news: Reviews){
        ReviewsBL().saveNewFavNews(news)
    }

    suspend fun deleteFavNews(news: Reviews){
        ReviewsBL().deleteNewFavNews(news)
    }

}