package com.example.netflixremake.model

import androidx.annotation.DrawableRes

// os que estao com o string e que nao sao obrigados
data class Movie(
    val id: Int,
    val coverUrl: String,
    val title: String = "",
    val desc: String = "",
    val cast: String = ""
)