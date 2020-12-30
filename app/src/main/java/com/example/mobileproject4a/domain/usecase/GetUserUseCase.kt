package com.example.mobileproject4a.domain.usecase

import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.entity.User

class GetUserUseCase (

    private val userRepository: UserRepository
    ) {

        suspend fun invoke(email: String): User{
            return userRepository.getUser(email)
        }
}