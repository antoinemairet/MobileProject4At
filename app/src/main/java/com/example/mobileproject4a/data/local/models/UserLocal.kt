/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 30/12/20 15:47
 *
 */

package com.example.mobileproject4a.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mobileproject4a.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "firstname") val firstName: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null
}

fun User.toData() : UserLocal{
    return UserLocal(
        email= email,
        password = password,
        firstName = firstName
    )
}

fun UserLocal.toEntity() : User{
    return User(
        email= email,
        password= password,
        firstName = firstName
    )
}