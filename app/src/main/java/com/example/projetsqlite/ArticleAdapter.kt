package com.example.projetsqlite

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(var items: List<ArticleModel>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_detail_article, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        var article = items[position]
        holder.charger(article)
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var description : TextView
        var card : CardView

        init {
            title= itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
            card = itemView.findViewById(R.id.card)

            card.setOnClickListener {
                Intent(itemView.context, DetailArticle::class.java).also {
                    it.putExtra("titre_article",title_article.text)
                    itemView.context.startActivity(it)
                }
            }
        }

        fun charger(article : Article){
            title_article.text = article.title
            content_article.text = article.content
        }
    }
}