package com.example.adoptame.presentacion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptame.controladores.adapters.ReviewsAdapter
import com.example.adoptame.database.entidades.Reviews
import com.example.adoptame.databinding.FragmentFavNewsBinding
import com.example.adoptame.logica.ReviewsBL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class FavNewsFragment : Fragment() {

    private lateinit var binding: FragmentFavNewsBinding

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
               ReviewsBL().getFavoritesNews()
            }
            binding.listRecyclerViewFav.adapter =
                ReviewsAdapter(items) { getNewsItem(it) }
            binding.listRecyclerViewFav.layoutManager =
                LinearLayoutManager(binding.listRecyclerViewFav.context)
            binding.progressBarFav.visibility = View.INVISIBLE
        }
    }

    private fun getNewsItem(newsEntity: Reviews) {
        var i = Intent(activity, ItemActivity::class.java)
        val jsonString = Json.encodeToString(newsEntity)
        i.putExtra("noticia", jsonString)
        startActivity(i)
    }

}