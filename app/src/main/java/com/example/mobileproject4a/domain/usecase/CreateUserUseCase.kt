/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 30/12/20 12:08
 *
 */

package com.example.mobileproject4a.domain.usecase

import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.entity.User

class CreateUserUseCase(
        private val userRepository: UserRepository
        ) {

    suspend fun invoke(user: User){
            userRepository.createUser(user)
    }
}