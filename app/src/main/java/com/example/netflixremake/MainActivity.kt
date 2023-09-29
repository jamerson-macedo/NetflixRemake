package com.example.netflixremake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.util.CategoryTask


class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: CategoryAdapter
    private lateinit var rv: RecyclerView

    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categories = mutableListOf<Category>()

        rv = findViewById(R.id.recycler_main)
        mainAdapter = CategoryAdapter(categories)
        // na lista principal main adapter teremos um recycler horixontal
// e dentyro dele tera outro na horizontasl


        rv.layoutManager=LinearLayoutManager(this)
        rv.adapter=mainAdapter

        CategoryTask().execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=82a3faf0-f31b-462d-9e92-a3591c0346d2")


    }



}
