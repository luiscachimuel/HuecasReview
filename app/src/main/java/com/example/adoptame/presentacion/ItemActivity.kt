package com.example.adoptame.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.adoptame.R
import com.example.adoptame.controladores.ReviewsController
import com.example.adoptame.databinding.ActivityItemBinding
import com.example.adoptame.database.entidades.ReviewsEntity
import com.example.adoptame.logica.RevewsBL
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding

    private var fav: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var n: ReviewsEntity? = null
        intent.extras?.let {
            n = Json.decodeFromString<ReviewsEntity>(it.getString("noticia").toString())
        }
        if (n != null) {
            loadNews(n!!)
        }

        binding.floatingActionButtonItem.setOnClickListener() {
            saveFavNews(n)
        }
    }


    private fun loadNews(reviewsEntity: ReviewsEntity) {
        binding.txtTitulo.text = reviewsEntity.author
        binding.txtAutor.text = reviewsEntity.title
        binding.txtDesc.text = reviewsEntity.desc
        binding.ratingBar.rating = reviewsEntity.rating.toFloat()
        Picasso.get().load(reviewsEntity.img).into(binding.imgNews)

        lifecycleScope.launch(Dispatchers.Main) {
            fav = withContext(Dispatchers.IO) { RevewsBL().checkIsSaved(reviewsEntity.id) }
            if (fav) {
                binding.floatingActionButtonItem.setImageResource(R.drawable.ic_favorite_24)
            }
        }
    }

    private fun saveFavNews(reviews: ReviewsEntity?) {
        if (reviews != null) {
            if (!fav) {
                lifecycleScope.launch {
                    ReviewsController().saveFavNews(reviews)
                    binding.floatingActionButtonItem.setImageResource(R.drawable.ic_favorite_24)
                }
            } else {
                lifecycleScope.launch {
                    ReviewsController().deleteFavNews(reviews)
                    binding.floatingActionButtonItem.setImageResource(R.drawable.ic_favorite_border_12)
                }
            }
        }
    }
}