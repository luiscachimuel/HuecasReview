package com.example.adoptame.controladores

import com.example.adoptame.database.entidades.ReviewsEntity
import com.example.adoptame.logica.RevewsBL
import com.example.adoptame.utils.EnumNews

class ReviewsController {

    suspend fun getNews(category: String, page: Int, apiType: EnumNews.APITypes): List<ReviewsEntity> {
        return when (apiType) {
            EnumNews.APITypes.NewsApi ->
                RevewsBL().getNewsList(category.toString(), page)
            EnumNews.APITypes.NewsCatcherApi ->
                RevewsBL().getNewsCatchList(category.toString(), page)
        }
    }

    suspend fun saveFavNews(reviews: ReviewsEntity) {
        RevewsBL().saveNewFavNews(reviews)
    }

    suspend fun deleteFavNews(reviews: ReviewsEntity) {
        RevewsBL().deleteNewFavNews(reviews)
    }

}