package com.example.netflixremake

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflixremake.model.ModelCS
import com.example.netflixremake.model.ModelCSItem
import com.example.netflixremake.model.Movie

class MovieAdapter(val movie: List<ModelCSItem>, @LayoutRes private val layoutId:Int) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movie[position]
        holder.bind(movie)

    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: ModelCSItem) {
           val imagetest: ImageView = itemView.findViewById(R.id.image_movie)
            Log.i("ingazera",movie.image)
            Glide.with(itemView.context).load(movie.image).placeholder(R.drawable.placeholder).into(imagetest);

        }
    }


}