package com.example.newsappmvp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappmvp.core.BaseViewHolder
import com.example.newsappmvp.databinding.NewsItemBinding
import com.example.newsappmvp.data.model.Article

class NewsAdapter(private val newsList: List<Article>,
                  private val itemClickListener: OnArticleClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnArticleClickListener {
        fun onArticleClick(article: Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = NewsViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onArticleClick(newsList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is NewsViewHolder -> holder.bind(newsList[position])
        }
    }

    override fun getItemCount(): Int = newsList.size

    inner class NewsViewHolder(private val binding: NewsItemBinding, private val context: Context) : BaseViewHolder<Article>(binding.root) {

        override fun bind(article: Article) {
            binding.tvSource.text = article.source.name
            Glide.with(context).load(article.urlToImage)
                    .centerCrop().into(binding.imgNews)
            binding.tvTitulo.text = article.title
        }
    }
}