package com.example.newsappmvp.view.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.navigation.fragment.findNavController
import com.example.newsappmvp.R
import com.example.newsappmvp.contract.NewsContract
import com.example.newsappmvp.databinding.FragmentNewsBinding
import com.example.newsappmvp.data.model.Article
import com.example.newsappmvp.presenter.NewsPresenter
import com.example.newsappmvp.view.adapter.NewsAdapter

class NewsFragment : Fragment(R.layout.fragment_news), NewsContract.NewsView,
        NewsAdapter.OnArticleClickListener {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        NewsPresenter(this).getDataFromApi()
        showProgressBar()
    }

    override fun onDataCompleteFromApi(newsList: List<Article>) {
        activity?.runOnUiThread { //Para correr en el Hilo principal
            adapter = NewsAdapter(newsList, this@NewsFragment)
            binding.rvNews.adapter = adapter
            hideProgressBar()
        }
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        println("Throwable: $throwable")
    }

    override fun onArticleClick(article: Article) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(
                article.author.toString(),
                article.content.toString(),
                article.description.toString(),
                article.publishedAt,
                article.source.name,
                article.title,
                article.url,
                article.urlToImage.toString()
        )
        findNavController().navigate(action)
    }

    override fun showProgressBar(){
        binding.progressBar.visibility = VISIBLE
    }
    override fun hideProgressBar(){
        binding.progressBar.visibility = INVISIBLE
    }
}