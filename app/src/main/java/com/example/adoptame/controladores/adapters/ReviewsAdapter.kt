package com.example.adoptame.controladores.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.R
import com.example.adoptame.databinding.ItemNewsListBinding
import com.example.adoptame.database.entidades.Reviews
import com.squareup.picasso.Picasso

class NewsAdapter(val listNews: List<Reviews>, val onClickItemSelected: (Reviews) -> Unit) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater.inflate(R.layout.item_news_list, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = listNews[position]
        holder.render(item, onClickItemSelected)
    }

    override fun getItemCount(): Int = listNews.size
}

class NewsViewHolder(itemNews: View) : RecyclerView.ViewHolder(itemNews) {

    private val binding: ItemNewsListBinding = ItemNewsListBinding.bind(itemNews)

    fun render(itemNewsEntity: Reviews, onClickItemSelected: (Reviews) -> Unit) {
        binding.txtTitulo.text = itemNewsEntity.title
        binding.txtDescripcion.text = itemNewsEntity.desc
        Picasso.get().load(itemNewsEntity.img).into(binding.imgNews1)

        itemView.setOnClickListener {
            onClickItemSelected(itemNewsEntity)
        }
    }
}