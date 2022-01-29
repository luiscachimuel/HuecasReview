package com.example.adoptame.presentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptame.controladores.adapters.NewsAdapter
import com.example.adoptame.databinding.FragmentListarBinding
import com.example.adoptame.entidades.News
import com.example.adoptame.logica.NoticiasBL
import com.squareup.picasso.Picasso


class ListarFragment : Fragment() {

    private lateinit var binding: FragmentListarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListarBinding.inflate(inflater, container, false)

        val lstNews = NoticiasBL().getNewsList()
        binding.listRecyclerView.adapter = NewsAdapter(lstNews)
        binding.listRecyclerView.layoutManager =
            LinearLayoutManager(binding.listRecyclerView.context)


        return binding.root
    }

}