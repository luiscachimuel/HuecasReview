package com.example.adoptame.util

import android.app.Application
import androidx.room.Room
import com.example.adoptame.database.ReviewsDataBase

class HuecasReview: Application() {
    companion object {
        private var db: ReviewsDataBase? = null

        fun getDatabase(): ReviewsDataBase {
            return db!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, ReviewsDataBase::class.java, "news_DB")
            .build()
    }
}