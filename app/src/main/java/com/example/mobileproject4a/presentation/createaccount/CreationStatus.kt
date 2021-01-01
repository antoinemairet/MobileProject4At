/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 31/12/20 11:23
 *
 */

package com.example.mobileproject4a.presentation.createaccount

sealed class CreationStatus

object CreationSuccess : CreationStatus()

object CreationError : CreationStatus()