package com.example.netflixremake

import android.graphics.drawable.LayerDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val toolbar:Toolbar=findViewById(R.id.movie_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_keyboard_backspace_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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