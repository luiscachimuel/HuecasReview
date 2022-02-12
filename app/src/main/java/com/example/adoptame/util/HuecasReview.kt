package com.example.adoptame.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.adoptame.database.ReviewsDataBase

class HuecasReview: Application() {
    companion object {
        private var db: ReviewsDataBase? = null
        private lateinit var dbShare: SharedPreferences

        fun getDatabase(): ReviewsDataBase {
            return db!!
        }

        fun getShareDB(): SharedPreferences {
            return dbShare!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, ReviewsDataBase::class.java, "reviews_DB")
            .build()

        dbShare = applicationContext.getSharedPreferences("login_data", Context.MODE_PRIVATE)
    }
}