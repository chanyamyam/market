package com.clean.market.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean.market.R
import com.clean.market.adapter.ArticleAdapter
import com.clean.market.databinding.FragmentHomeBinding
import com.clean.market.model.ArticleModel

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var articleAdapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)


        articleAdapter = ArticleAdapter()
        articleAdapter.submitList(mutableListOf<ArticleModel>().apply {
            add(ArticleModel("0","aaaa",19990221,"5000원",""))
            add(ArticleModel("0","aaaa",20210221,"50000원",""))
        })

        binding.articleRecyclerView.layoutManager =LinearLayoutManager(context)
        binding.articleRecyclerView.adapter = articleAdapter
    }
}