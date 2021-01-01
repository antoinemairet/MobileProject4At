package com.example.mobileproject4a.presentation.list

import com.example.mobileproject4a.domain.entity.Movie

sealed class APICallStatus
data class APICallSuccess(val movieList: List<Movie>):APICallStatus()
object APICallError:APICallStatus()