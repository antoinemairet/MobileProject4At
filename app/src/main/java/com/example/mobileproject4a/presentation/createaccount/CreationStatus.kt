package com.example.mobileproject4a.presentation.createaccount

sealed class CreationStatus

object CreationSuccess : CreationStatus()

object CreationError : CreationStatus()