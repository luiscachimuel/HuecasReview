package com.example.adoptame.presentacion

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptame.controladores.ListNewsAdapter
import com.example.adoptame.database.entidades.ReviewsEntity
import com.example.adoptame.databinding.FragmentFavNewsBinding
import com.example.adoptame.logica.RevewsBL
import kotlinx.coroutines.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class FavNewsFragment : Fragment() {

    private lateinit var binding: FragmentFavNewsBinding
    private var job: Job? = null

    private val TAG: String = "UCE"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        super.onStart()
        binding.progressBarFav.visibility = View.VISIBLE
        lifecycleScope.launch(Dispatchers.Main) {
            val items = withContext(Dispatchers.IO) {
                RevewsBL().getFavoritesNews()
            }
            binding.listRecyclerViewFav.adapter =
                ListNewsAdapter(items) { getNewsItem(it) }
            binding.listRecyclerViewFav.layoutManager =
                LinearLayoutManager(binding.listRecyclerViewFav.context)
            binding.progressBarFav.visibility = View.INVISIBLE
        }
    }

    private fun getNewsItem(reviewsEntity: ReviewsEntity) {
        var i = Intent(activity, ItemActivity::class.java)
        val jsonString = Json.encodeToString(reviewsEntity)
        i.putExtra("noticia", jsonString)
        startActivity(i)
    }

}