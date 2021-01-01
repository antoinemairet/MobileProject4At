/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 30/12/20 15:22
 *
 */

package com.example.mobileproject4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email:String) : LoginStatus()

object LoginError : LoginStatus()