package com.example.adoptame.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.adoptame.database.dao.ReviewsDAO
import com.example.adoptame.database.entidades.Reviews

@Database(
    entities = [Reviews::class],
    version = 1
)

abstract class ReviewsDataBase : RoomDatabase(){
    abstract fun reviewsDao(): ReviewsDAO
}