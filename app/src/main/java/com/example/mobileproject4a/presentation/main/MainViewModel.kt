package com.example.mobileproject4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject4a.domain.entity.User
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.launch

class MainViewModel(
        private val createUserUseCase: CreateUserUseCase
): ViewModel() {

    val counter :MutableLiveData<Int> = MutableLiveData()
    init{
        counter.value = 0
    }

    fun onClickIncrement(emailUser:String){
        viewModelScope.launch {
            createUserUseCase.invoke(User(emailUser))
        }
    }
}