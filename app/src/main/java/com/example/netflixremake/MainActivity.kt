package com.example.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainadapter = MainAdapter()
        val rv: RecyclerView = findViewById(R.id.recycler_main)

        with(rv) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainadapter
        }
    }
}