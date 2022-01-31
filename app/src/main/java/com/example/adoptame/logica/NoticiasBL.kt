package com.example.adoptame.logica

import com.example.adoptame.casosUso.NewsUseCase
import com.example.adoptame.entidades.Reviews
import kotlin.random.Random

class NoticiasBL {

    fun getNewsList(): List<Reviews> {
        return NewsUseCase().getAllNews()
    }

    fun getOneNews(): Reviews {
        val r = (0..3).random()
        return NewsUseCase().getAllNews()[r]
    }

}