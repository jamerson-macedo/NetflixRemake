package com.example.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie
import com.example.netflixremake.util.InternetTask

class MainActivity : AppCompatActivity() {
    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categories = mutableListOf<Category>()
        InternetTask().execute("https://rickandmortyapi.com/api/character")



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