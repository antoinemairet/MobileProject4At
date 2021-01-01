package com.example.mobileproject4a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mobileproject4a.R
import com.example.mobileproject4a.domain.entity.Movie
import kotlinx.android.synthetic.main.row_layout.view.*


class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ListViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    fun submitList(movieList:List<Movie>){
        items = movieList
    }
    class ListViewHolder constructor(
            itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val title = itemView.title
        val image = itemView.image
        val rank = itemView.rank

        fun bind(movie: Movie){
            title.text = movie.title
            rank.text = movie.rank.toString()

            //Basic Request Options to handle Glide
            val requestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

            //Using Glide to display images from URL
            Glide.with(itemView.context)
                    .applyDefaultRequestOptions(requestOptions)
                    .load(movie.image)
                    .into(image)
        }

    }
}

