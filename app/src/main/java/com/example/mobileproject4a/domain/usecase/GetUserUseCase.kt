/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 21:10
 *
 */

package com.example.mobileproject4a.domain.usecase

import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.entity.User

class GetUserUseCase (

    private val userRepository: UserRepository
    ) {

        fun invoke(email: String, password: String): User?{
            return userRepository.getUser(email, password)
        }
}