package com.example.adoptame.casosUso

import com.example.adoptame.data.api.RetrofitAPI
import com.example.adoptame.data.api.entidades.newsApi.toReviewEntity
import com.example.adoptame.data.api.service.RestaurantsService
import com.example.adoptame.database.entidades.ReviewsEntity
import com.example.adoptame.utils.Adoptame

class ReviewsUseCase {

    private val newsList = listOf<ReviewsEntity>(
        ReviewsEntity(
            1,
            "Restaurante 1",
            "Comida Argentina",
            "This deal could help sell more Xbox Series Xs in the short term, but Microsoft has much bigger VR/AR fish to fry. Microsoft claims its recent Activision Blizzard acquisition is about more than just gaming: it will provide building blocks for the metaverse…",
            4.5,
            "https://gestion.pe/resizer/h6Zig3yPGvhlUSwmFYYROlq2I7o=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/2YSGG6JP3NGRVPYV3NY5VT7VYU.jpg"
        ),
        ReviewsEntity(
            2,
            "Restaurante 2",
            "Comida Italiana",
            "Exclusive: Experts aim to find out whether there are hotspots around country where electronic waste is avoidedFrom fancy toys to smartphones, when technology breaks, it often seems simplest to ditch it for a new model.But now experts are hoping to challenge t…",
            3.5,
            "https://www.eluniversal.com.co/binrepository/1200x675/0c0/0d0/none/13704/EBKF/restaurante_3538118_20200825164948.jpg"
        ),
        ReviewsEntity(
            3,
            "Restaurante 3",
            "Comida Mexicana",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …",
            4.0,
            "https://phantom-expansion.unidadeditorial.es/fe64c996e71147ca755d4e062fcaac2f/crop/0x0/2044x1363/resize/660/f/webp/assets/multimedia/imagenes/2021/09/11/16313142847552.jpg"
        ),
        ReviewsEntity(
            4,
            "Restaurante 4",
            "Comida Española",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …",
            5.0,
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Restaurant_N%C3%A4sinneula.jpg/800px-Restaurant_N%C3%A4sinneula.jpg"
        ),
        ReviewsEntity(
            5,
            "Restaurante 5",
            "Mariscos",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …",
            3.5,
            "https://img.goraymi.com/2019/02/12/fbce445c00d496e4c39e432fffbbdecc_xl.jpg"
        ),
        ReviewsEntity(
            6,
            "Restaurante 6",
            "Comida Típica",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …",
            4.5,
            "https://static.wixstatic.com/media/9c253e_328a7e49686e44899acac92b52375688~mv2.jpg/v1/fill/w_2500,h_1224,al_c/9c253e_328a7e49686e44899acac92b52375688~mv2.jpg"
        )

    )

    suspend fun getAllRestaurantsApi(
    ): List<ReviewsEntity> {

        var resp: List<ReviewsEntity> = ArrayList<ReviewsEntity>()

        val service = RetrofitAPI.getRestaurantsApi().create(RestaurantsService::class.java)
        val call = service.getAllRestaurants()
        resp = if (call.isSuccessful) {
            return call.body()!!.restaurants.map {
                it.toReviewEntity()
            }
        } else (ArrayList<ReviewsEntity>())
        return resp
        //return newsList
    }

    suspend fun getFavoritesNews(): List<ReviewsEntity> {
        val db = Adoptame.getDatabase()
        return db.newsDao().getAllNews()
    }

    suspend fun saveNewFavNews(reviews: ReviewsEntity) {
        Adoptame.getDatabase().newsDao().insertNews(reviews)
    }

    suspend fun deleteNewFavNews(reviews: ReviewsEntity) {
        Adoptame.getDatabase().newsDao().deleteNewsById(reviews.id)
    }

    suspend fun getOneNews(id: Int): ReviewsEntity {
        return Adoptame.getDatabase().newsDao().getNewsById(id)
    }
}
