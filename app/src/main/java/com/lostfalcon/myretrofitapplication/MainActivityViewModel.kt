package com.lostfalcon.myretrofitapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import com.lostfalcon.myretrofitapplication.CloudConnector.ApiService
import com.lostfalcon.myretrofitapplication.Model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityViewModel : ViewModel() {
    private val TAG = "MainActivityViewModel"
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : ApiService = retrofit.create(ApiService::class.java)

    fun fetchPosts() {

        service.getPosts().enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    Log.d(TAG, "successful response: ${response.code()}")
                    val posts = response.body()
                    Log.e(TAG, "Posts: $posts")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                println("Failed to fetch posts")
            }
        }

        )
    }
}