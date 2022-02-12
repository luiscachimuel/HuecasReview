package com.example.adoptame.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.adoptame.R
import com.example.adoptame.controladores.ReviewController
import com.example.adoptame.database.entidades.Reviews
import com.example.adoptame.databinding.ActivityItemBinding
import com.example.adoptame.logica.ReviewsBL
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

        var n: Reviews? = null
        intent.extras?.let {
            n = Json.decodeFromString<Reviews>(it.getString("noticia").toString())
        }
        if (n != null) {
            loadNews(n!!)
        }

        binding.floatingActionButtonItem.setOnClickListener() {
            saveFavNews(n)
        }
    }


    private fun loadNews(newsEntity: Reviews) {
        binding.txtTitulo.text = newsEntity.title
        binding.txtAutor.text = newsEntity.subTitle
        binding.txtDesc.text = newsEntity.desc
        Picasso.get().load(newsEntity.img).into(binding.imgNews)

        lifecycleScope.launch(Dispatchers.Main) {
            fav = withContext(Dispatchers.IO) { ReviewsBL().checkIsSaved(newsEntity.id) }
            if (fav) {
                binding.floatingActionButtonItem.setImageResource(R.drawable.ic_favorite_24)
            }
        }
    }

    private fun saveFavNews(news: Reviews?) {
        if (news != null) {
            if (!fav) {
                lifecycleScope.launch {
                   ReviewController().saveFavNews(news)
                    binding.floatingActionButtonItem.setImageResource(R.drawable.ic_favorite_24)
                }
            } else {
                lifecycleScope.launch {
                    ReviewController().deleteFavNews(news)
                    binding.floatingActionButtonItem.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
        }
    }
}