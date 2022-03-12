package com.example.adoptame.database.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "news")
@Serializable
data class ReviewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String?,
    val title: String?,
    val desc: String?,
    val rating: Double,
    var img: String?
)
 {
    init {
        if (this.img == null) {
            this.img =
                "https://isabelpaz.com/wp-content/themes/nucleare-pro/images/no-image-box.png"
        }
    }
 }