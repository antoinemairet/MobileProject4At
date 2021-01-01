/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 20:38
 *
 */

package com.example.mobileproject4a.presentation.list

import com.example.mobileproject4a.domain.entity.Movie

sealed class APICallStatus
data class APICallSuccess(val movieList: List<Movie>):APICallStatus()
object APICallError:APICallStatus()