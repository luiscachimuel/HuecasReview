package com.example.adoptame.database.dao

import androidx.room.*
import com.example.adoptame.database.entidades.ReviewsEntity

@Dao
interface ReviewsDAO {

    @Query("SELECT * FROM news")
    suspend fun getAllNews(): List<ReviewsEntity>

    @Query("SELECT * FROM news WHERE id = :idNews")
    suspend fun getNewsById(idNews: Int): ReviewsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(reviews: ReviewsEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNews(reviews: ReviewsEntity)

    @Delete()
    suspend fun deleteOneNews(reviews: ReviewsEntity)

    @Query("DELETE FROM news")
    suspend fun cleanDbNews()

    @Query("DELETE FROM news WHERE id = :idNews")
    suspend fun deleteNewsById(idNews: Int)

}