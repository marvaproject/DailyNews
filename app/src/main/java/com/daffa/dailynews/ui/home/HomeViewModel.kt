package com.daffa.dailynews.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.dailynews.network.api.ApiConfig
import com.daffa.dailynews.network.response.HomeResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val listHome = MutableLiveData<List<HomeResponseItem>>()

    fun getHomeModel(){
        ApiConfig().getApiService().getHome().enqueue(object : Callback<List<HomeResponseItem>> {
            override fun onResponse(
                call: Call<List<HomeResponseItem>>,
                response: Response<List<HomeResponseItem>>
            ) {
                listHome.value = response.body()
            }

            override fun onFailure(call: Call<List<HomeResponseItem>>, t: Throwable) {

            }
        })
    }
    fun getListHome() : LiveData<List<HomeResponseItem>> = listHome
}