package com.example.adoptame.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.adoptame.database.dao.ReviewsDAO
import com.example.adoptame.database.entidades.ReviewsEntity

@Database(
    entities = [ReviewsEntity::class],
    version = 1
)
abstract class ReviewsDataBase : RoomDatabase() {

    abstract fun newsDao(): ReviewsDAO

}