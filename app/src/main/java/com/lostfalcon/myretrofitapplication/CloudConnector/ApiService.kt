package com.lostfalcon.myretrofitapplication.CloudConnector

import retrofit2.http.GET
import retrofit2.Call;
import com.lostfalcon.myretrofitapplication.Model.Post


// Api Service for JsonPlaceholder
interface ApiService {
    @GET("posts")
    fun getPosts() : Call<List<Post>>
}