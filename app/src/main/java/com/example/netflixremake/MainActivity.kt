package com.example.netflixremake

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.ModelCS
import com.example.netflixremake.model.ModelCSItem
import com.example.netflixremake.util.NetWorkUtils
import com.example.netflixremake.util.RetrofitAPI
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var models = mutableListOf<ModelCSItem>()
    private lateinit var mainAdapter: CategoryAdapter
    private lateinit var rv: RecyclerView

    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getallcategories(models)
        rv = findViewById(R.id.recycler_main)
        mainAdapter = CategoryAdapter(models)


    }
//("https://bymykel.github.io/CSGO-API/api/en/collections.json")// api harryhttps://hp-api.onrender.com/api/characters
//https://picsum.photos/v2/list?page=2&limit=100


    // na lista principal main adapter teremos um recycler horixontal
// e dentyro dele tera outro na horizontasl
    fun getallcategories(models: MutableList<ModelCSItem>) {
        val retrofit = NetWorkUtils.getinstance("https://bymykel.github.io/CSGO-API/api/")
        val endpoint = retrofit.create(RetrofitAPI::class.java)
        endpoint.getall().enqueue(object : Callback<List<ModelCSItem>?> {
            override fun onResponse(
                call: Call<List<ModelCSItem>?>,
                response: Response<List<ModelCSItem>?>
            ) {
                //val responseBody = response.body()!!
                val stringBuilder = StringBuilder()
                // for (i in responseBody) {
                // stringBuilder.append(i.contains.map { it.name })
                //   stringBuilder.append(i.name)
                // stringBuilder.append("\n")
                //

                val remoteResponse = response.body()!!

                mainAdapter = CategoryAdapter(remoteResponse)
                with(rv) {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = mainAdapter
                }

            }

            override fun onFailure(call: Call<List<ModelCSItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
