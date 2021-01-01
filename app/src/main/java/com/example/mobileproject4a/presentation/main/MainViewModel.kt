/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 31/12/20 11:23
 *
 */

package com.example.mobileproject4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import com.example.mobileproject4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(

        private val getUserUseCase: GetUserUseCase
): ViewModel() {

    val loginLiveData :MutableLiveData<LoginStatus> = MutableLiveData()


    fun onClickedLogin(email: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {

            val user =getUserUseCase.invoke(email, password)
            val loginStatus :LoginStatus = if (user != null){
                    LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value =loginStatus
            }

        }
    }


}