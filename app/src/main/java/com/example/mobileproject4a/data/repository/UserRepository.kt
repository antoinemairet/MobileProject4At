/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 31/12/20 12:43
 *
 */

package com.example.mobileproject4a.data.repository

import com.example.mobileproject4a.data.local.DatabaseDao
import com.example.mobileproject4a.data.local.models.UserLocal
import com.example.mobileproject4a.data.local.models.toData
import com.example.mobileproject4a.data.local.models.toEntity
import com.example.mobileproject4a.domain.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {
    fun createUser(user: User){
        databaseDao.insert(user.toData())
    }
    fun getUser(email:String, password:String) : User?{
        val userLocal: UserLocal? = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}