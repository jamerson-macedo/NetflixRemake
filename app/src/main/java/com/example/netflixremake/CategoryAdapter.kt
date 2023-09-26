package com.example.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.WithHint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie

class CategoryAdapter(val category: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val category = category[position]
        holder.bind(category)

    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            val txt_category:TextView=itemView.findViewById(R.id.txt_category)
            txt_category.text=category.name
           val rv_category:RecyclerView=itemView.findViewById(R.id.recycler_category)
            with(rv_category){
                layoutManager=LinearLayoutManager(itemView.context,RecyclerView.HORIZONTAL,false)
                adapter=MovieAdapter(category.movieList)
            }
        }
    }


}