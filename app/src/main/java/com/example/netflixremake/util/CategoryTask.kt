package com.example.netflixremake.util

import android.util.Log
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection


class CategoryTask {

    fun execute(url: String) {
        // executando uma nova thread
        val executors = Executors.newSingleThreadExecutor()

        executors.execute {
            // nova thread
            var urlConnection: HttpsURLConnection? = null
            var stream: InputStream? = null
            try {
                val requestURL = URL(url) // ABRIR URL
                urlConnection = requestURL.openConnection() as HttpsURLConnection // devolve uma url
                // 2s
                urlConnection.readTimeout = 2000
                // tempo para conectar
                urlConnection.connectTimeout = 2000

                val statuscode = urlConnection.responseCode
                if (statuscode > 400) {
                    // se der erro lanço uma exceção
                    // joga para o catch
                    throw IOException("erro na comunicação")
                }
                // sequencia de bytes
                stream = urlConnection.inputStream
                val jsonAsString = stream.bufferedReader().use {// byte -> string
                    it.readText()
                }
                val categories = tocategory(jsonAsString)
                Log.i("teste", categories.toString())

            } catch (e: IOException) {
                Log.e("erro", e.message ?: " erro desconhecido", e)

            } finally {
                // DANDO CERTO OU ERRADO ELE VAI LIMPAR A MEMORIA
                // garantindo que ta fechando
                urlConnection?.disconnect()
                stream?.close()

            }


        }

    }

    private fun tocategory(jsonString: String): List<Category> {
        val categories = mutableListOf<Category>()
        // transformar em jsonObject
        val jsonRoot = JSONObject(jsonString)
        val jsoncategories = jsonRoot.getJSONArray("category")
        for (i in 0 until jsoncategories.length()) {

            // pegando cada dado da category
            // PEGUEI A CATEGORY
            val jsonCategory = jsoncategories.getJSONObject(i)
            val title = jsonCategory.getString("title")
            val jsonmovies = jsonCategory.getJSONArray("movie")
            // AGORA VOU PEGAR OS MOVIES
            val movies = mutableListOf<Movie>()

            for (j in 0 until jsonmovies.length()) {
                val jsonmovie = jsonmovies.getJSONObject(j)
                val id = jsonmovie.getInt("id")
                val coverUrl = jsonmovie.getString("cover_url")

                movies.add(Movie(id, coverUrl))


            }
            categories.add(Category(title, movies))
        }


        return categories
    }
}