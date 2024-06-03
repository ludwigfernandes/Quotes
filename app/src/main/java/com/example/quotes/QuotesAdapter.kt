package com.example.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Response

class QuotesAdapter(
    private val quotesList: Response<List<Quote>>,
    private val photos: List<Photo>
) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quote: TextView = itemView.findViewById(R.id.tvQuote)
        val author: TextView = itemView.findViewById(R.id.tvAuthor)
        val background: ImageView=itemView.findViewById(R.id.ivImages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesAdapter.ViewHolder, position: Int) {
        val quote = quotesList.body()?.get(position)
        val photo=photos[position]

        quote?.let {
            holder.quote.text = holder.itemView.context.getString(R.string.fetched_quote, it.q)
            holder.author.text = holder.itemView.context.getString(R.string.fetched_author, it.a)

            Glide.with(holder.itemView.context)
                .load(photo.urls.regular)
                .into(holder.background)
        }
    }

    override fun getItemCount(): Int {
        //return quotesList.body()?.size ?: 0
        return photos.size
    }
}