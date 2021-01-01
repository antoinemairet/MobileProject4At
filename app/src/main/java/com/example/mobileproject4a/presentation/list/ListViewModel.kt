/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 21:10
 *
 */

package com.example.mobileproject4a.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobileproject4a.data.remote.MovieAPI
import com.example.mobileproject4a.data.remote.RestMovieResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel: ViewModel() {
    val APIMovieCallLiveData: MutableLiveData<APICallStatus> = MutableLiveData()

    fun makeApiCall() {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://imdb-api.com/en/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val movieAPI: MovieAPI = retrofit.create(MovieAPI::class.java)
        movieAPI
            .getMoviesResponse
            .enqueue(object : Callback<RestMovieResponse?> {
                override fun onResponse(
                    call: Call<RestMovieResponse?>,
                    response: Response<RestMovieResponse?>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val movieList = response.body()!!.results
                        APIMovieCallLiveData.value = APICallSuccess(movieList)
                    }
                }

                override fun onFailure(call: Call<RestMovieResponse?>?, t: Throwable) {
                    APIMovieCallLiveData.value = APICallError
                }
            })
    }
}