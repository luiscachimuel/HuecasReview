package com.example.adoptame.database.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "reviews")
data class Reviews(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String?,
    val subTitle: String?,
    val desc: String?,
    var img: String?)
{
    init {
        if (this.img == null) {
            this.img =
                "https://isabelpaz.com/wp-content/themes/nucleare-pro/images/no-image-box.png"
        }
    }
}