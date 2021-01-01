/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 20:55
 *
 */

package com.example.mobileproject4a.data.remote

import com.example.mobileproject4a.domain.entity.Movie

data class RestMovieResponse (

        val results: List<Movie>

)