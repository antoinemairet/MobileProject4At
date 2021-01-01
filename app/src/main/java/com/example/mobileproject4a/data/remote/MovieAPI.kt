/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 20:58
 *
 */

package com.example.mobileproject4a.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface MovieAPI {
    @get:GET("/API/Top250Movies/k_O4bZ6v9Q")
    val getMoviesResponse: Call<RestMovieResponse>
}