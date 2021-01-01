package com.example.mobileproject4a.presentation.createaccount

import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileproject4a.domain.entity.User
import com.example.mobileproject4a.domain.usecase.GetUserUseCase
import com.example.mobileproject4a.presentation.main.LoginError
import com.example.mobileproject4a.presentation.main.LoginStatus
import com.example.mobileproject4a.presentation.main.LoginSuccess
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class CreateAccountViewModel(

    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase

    ) : ViewModel() {

    val creationLiveData :MutableLiveData<CreationStatus> = MutableLiveData()

    fun onClickedSubmit(first_name:String, email: String, password: String){
       viewModelScope.launch(Dispatchers.IO) {
            val user =getUserUseCase.invoke(email, password)
            val creationStatus :CreationStatus = if (user != null){

                CreationError
            }else{
                val user = User(first_name,email,password)
                createUserUseCase.invoke(user)
                CreationSuccess
            }
            withContext(Dispatchers.Main){
                creationLiveData.value =creationStatus
            }
        }

        }

}