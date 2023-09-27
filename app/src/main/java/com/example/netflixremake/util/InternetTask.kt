package com.example.netflixremake.util

import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class InternetTask {
    fun execute(url: String) {


        // vai abrir um processo paralelo
        val executor = Executors.newSingleThreadExecutor()
        executor.execute {
            try {
                // nova thread
                val request = URL(url)
                // https
                val urlConnection = request.openConnection() as HttpURLConnection
                // tmepo de leitura(2s)
                urlConnection.readTimeout = 2000
                urlConnection.readTimeout = 2000
                // buscando as informaçoes
                val statuscode: Int = urlConnection.responseCode
                if (statuscode > 400) {
                    // LAN;O UMAM EXESSÃO de UI
                    throw IOException("erro na comunicação com servidor")

                }
                // deu certo então
                val stream = urlConnection.inputStream // sequencia de bytes
                val jsonAsString =
                    stream.bufferedReader().use { it.readText() } // transforma bytges em string
                Log.i("teste", jsonAsString)

            } catch (e: IOException) {
                Log.e("teste", e.message ?: "erro desconhecido", e)
            }

        }
    }
}