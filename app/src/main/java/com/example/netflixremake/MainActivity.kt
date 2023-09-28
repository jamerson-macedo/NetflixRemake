package com.example.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Category
import com.example.netflixremake.model.ModelCS
import com.example.netflixremake.model.ModelCSItem
import com.example.netflixremake.util.NetWorkUtils

import com.example.netflixremake.util.RetrofitAPI

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {
    //MVC
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val categories = mutableListOf<Category>()

        //("https://bymykel.github.io/CSGO-API/api/en/collections.json")// api harryhttps://hp-api.onrender.com/api/characters
        //https://picsum.photos/v2/list?page=2&limit=100

        getallcategories()
        // na lista principal main adapter teremos um recycler horixontal
        // e dentyro dele tera outro na horizontasl




    }

    fun getallcategories() {
        val retrofit = NetWorkUtils.getinstance("https://bymykel.github.io/CSGO-API/api/")
        val endpoint = retrofit.create(RetrofitAPI::class.java)
        endpoint.getall().enqueue(object : Callback<ModelCS?> {
            override fun onResponse(call: Call<ModelCS?>, response: Response<ModelCS?>) {
                val responseBody=response.body()!!

                val stringBuilder=StringBuilder()
                for (i in responseBody){
                   // stringBuilder.append(i.contains.map { it.id })
                   // stringBuilder.append(i.name)
                    //stringBuilder.append("\n")
1                }

                val list2 = ArrayList<ModelCSItem>()
                for(j in responseBody){
                    list2.add(j)
                    list2.trimToSize()
                }

                Log.i("zezin",list2.toString())

                val mainadapter = CategoryAdapter(list2)
                val rv: RecyclerView = findViewById(R.id.recycler_main)
                with(rv) {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = mainadapter
                }
            }



            override fun onFailure(call: Call<ModelCS?>, t: Throwable) {
                Log.i("jose",t.toString())
            }
        })
    }
}