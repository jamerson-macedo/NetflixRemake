package com.example.netflixremake.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.Movie
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection


class ImageTask(private val callback: CallBack) {
    // entra no meio do fluxo e retorna o post pra main porincipal
    private val handler = Handler(Looper.getMainLooper())
    private val executors = Executors.newSingleThreadExecutor()

    interface CallBack {

        fun onResult(bitmap: Bitmap)

    }

    fun execute(url: String) {
        // executando uma nova thread


        executors.execute {
            // antes de começar

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
                    throw IOException("erro na comunicação com servidor !")
                }
                // sequencia de bytes
                stream = urlConnection.inputStream
                val bitmap=BitmapFactory.decodeStream(stream)

                // roda dentro da ui

                handler.post { callback.onResult(bitmap) }


            } catch (e: IOException) {
                val message=e.message ?: " erro desconhecido"
                Log.e("erro", e.message ?: " erro desconhecido", e)
                // caso de erro
                // mandando para a ui



            } finally {
                // DANDO CERTO OU ERRADO ELE VAI LIMPAR A MEMORIA
                // garantindo que ta fechando
                urlConnection?.disconnect()
                stream?.close()

            }


        }

    }


}