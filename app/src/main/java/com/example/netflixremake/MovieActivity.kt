package com.example.netflixremake

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)


        val txt_title:TextView=findViewById(R.id.title_movie)
        val txt_description:TextView=findViewById(R.id.description_movie)
        val txt_cast:TextView=findViewById(R.id.cast_movie)
        val recycler_simila:RecyclerView=findViewById(R.id.recycler_similar)

        val movies = mutableListOf<Movie>()
        recycler_simila.layoutManager=GridLayoutManager(this,3)
       // recycler_simila.adapter=MovieAdapter(movies,R.layout.movie_item_similar)


        val toolbar:Toolbar=findViewById(R.id.movie_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title=null
    // busquei nosso layer-list
        val layerDrawable:LayerDrawable=ContextCompat.getDrawable(this,R.drawable.shadows) as LayerDrawable
        // busquei o filme
        val movieCover=ContextCompat.getDrawable(this,R.drawable.movie_2)
        // atribui a esse layer list
        layerDrawable.setDrawableByLayerId(R.id.drawble_cover,movieCover)
        // setei a imagem
        val coverimg:ImageView=findViewById(R.id.movie_img)
        coverimg.setImageDrawable(layerDrawable)
    }
}