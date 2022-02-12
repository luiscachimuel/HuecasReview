package com.example.adoptame.casosUso

import com.example.adoptame.database.entidades.Reviews
import com.example.adoptame.util.HuecasReview

class ReviewsUseCase {

    private val newsList = listOf<Reviews>(
        Reviews(
            1,
            "Restaurante 1",
            "Comida argentina",
            "This deal could help sell more Xbox Series Xs in the short term, but Microsoft has much bigger VR/AR fish to fry. Microsoft claims its recent Activision Blizzard acquisition is about more than just gaming: it will provide building blocks for the metaverse…",
            "https://gestion.pe/resizer/h6Zig3yPGvhlUSwmFYYROlq2I7o=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/2YSGG6JP3NGRVPYV3NY5VT7VYU.jpg"
        ),
        Reviews(
            2,
            "Restaurante 2",
            "Comida italiana",
            "Exclusive: Experts aim to find out whether there are hotspots around country where electronic waste is avoidedFrom fancy toys to smartphones, when technology breaks, it often seems simplest to ditch it for a new model.But now experts are hoping to challenge t…",
            "https://www.eluniversal.com.co/binrepository/1200x675/0c0/0d0/none/13704/EBKF/restaurante_3538118_20200825164948.jpg"
        ),
        Reviews(
            3,
            "Restaurante 3",
            "Comida mexicana",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …",
            "https://phantom-expansion.unidadeditorial.es/fe64c996e71147ca755d4e062fcaac2f/crop/0x0/2044x1363/resize/660/f/webp/assets/multimedia/imagenes/2021/09/11/16313142847552.jpg"
        )
    )


    fun getAllNews(): List<Reviews> {
        return newsList
    }

    suspend fun getFavoritesNews(): List<Reviews> {
        val db = HuecasReview.getDatabase()
        return db.reviewsDao().getAllNews()
    }

    suspend fun saveNewFavNews(news: Reviews) {
        HuecasReview.getDatabase().reviewsDao().insertNews(news)
    }

    suspend fun deleteNewFavNews(news: Reviews) {
        HuecasReview.getDatabase().reviewsDao().deleteNewsById(news.id)
    }

    suspend fun getOneNews(id: Int): Reviews {
        return HuecasReview.getDatabase().reviewsDao().getNewsById(id)
    }

}