package com.example.newsappmvp.view.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsappmvp.R
import com.example.newsappmvp.contract.NewsContract
import com.example.newsappmvp.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail), NewsContract.NewsDetail {
    private lateinit var binding: FragmentNewsDetailBinding
    private val args by navArgs<NewsDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsDetailBinding.bind(view)
        showData()
    }

    override fun showData() {
        binding.tvDate.text = args.publishedAt.take(10)
        binding.tvAuthor.text = args.author
        binding.tvTitleText.text = args.title
        binding.tvDescriptionText.text = args.description
        binding.tvContentText.text = args.content
        binding.tvUrlText.text = args.url

        Glide.with(requireContext()).load(args.urlToImage)
            .centerCrop().into(binding.imgNews)
        Glide.with(requireContext()).load(args.urlToImage)
            .centerCrop().into(binding.imgBackground)
    }
}