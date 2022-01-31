package com.example.adoptame.casosUso

import com.example.adoptame.entidades.Reviews

class NewsUseCase {

    private val newsList = listOf<Reviews>(
        Reviews(
            "Restaurante 1",
            "Comida argentina",
            "This deal could help sell more Xbox Series Xs in the short term, but Microsoft has much bigger VR/AR fish to fry. Microsoft claims its recent Activision Blizzard acquisition is about more than just gaming: it will provide building blocks for the metaverse…"),
        Reviews(
            "Restaurante 2",
            "Comida italiana",
            "Exclusive: Experts aim to find out whether there are hotspots around country where electronic waste is avoidedFrom fancy toys to smartphones, when technology breaks, it often seems simplest to ditch it for a new model.But now experts are hoping to challenge t…"),
        Reviews(
            "Restaurante 3",
            "Comida mexicana",
            "Long-time Slashdot reader Qbertino writes: The Free Open Source 3D production software Blender has been released in version 3.0 (official showreel) with more new features, improvements and performance optimizations as well as further improved workflows. \n\nIn …"
        )
    )


    fun getAllNews(): List<Reviews> {
        return newsList
    }

}