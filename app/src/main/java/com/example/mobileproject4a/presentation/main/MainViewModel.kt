package com.example.mobileproject4a.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject4a.domain.entity.User
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import com.example.mobileproject4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase
): ViewModel() {

    val counter :MutableLiveData<Int> = MutableLiveData()
    init{
        counter.value = 0
    }

    fun onClickIncrement(emailUser:String){
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test1@test.fr"))
            delay(1000)
            val user =getUserUseCase.invoke("test1@test.fr")

        }
    }
}