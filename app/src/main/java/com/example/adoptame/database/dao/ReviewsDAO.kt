package com.example.adoptame.database.dao

import androidx.room.*
import com.example.adoptame.database.entidades.Reviews

@Dao
interface ReviewsDAO {
    @Query("SELECT * FROM reviews")
    suspend fun getAllNews(): List<Reviews>

    @Query("SELECT * FROM reviews WHERE id = :idNews")
    suspend fun getNewsById(idNews: Int): Reviews

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(news: Reviews)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNews(news: Reviews)

    @Delete()
    suspend fun deleteOneNews(news: Reviews)

    @Query("DELETE FROM reviews")
    suspend fun cleanDbNews()

    @Query("DELETE FROM reviews WHERE id = :idNews")
    suspend fun deleteNewsById(idNews: Int)
}