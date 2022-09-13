package com.daffa.dailynews.network.api

import com.daffa.dailynews.network.response.HomeResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/games")
    fun getHome() : Call<List<HomeResponseItem>>
}