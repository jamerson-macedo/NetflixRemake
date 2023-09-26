package com.example.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie

class MainActivity : AppCompatActivity() {
    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categories = mutableListOf<Category>()
        for (j in 0 until 10) {
            val movies = mutableListOf<Movie>()
            for (i in 0 until 15) {
                val movie = Movie(R.drawable.movie_1)
                movies.add(movie)
            }
            val category = Category("cat $j", movies)
            categories.add(category)
        }


        // na lista principal main adapter teremos um recycler horixontal
        // e dentyro dele tera outro na horizontasl
        val mainadapter = CategoryAdapter(categories)
        val rv: RecyclerView = findViewById(R.id.recycler_main)

        with(rv) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainadapter
        }
    }
}