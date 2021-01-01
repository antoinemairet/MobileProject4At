/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 30/12/20 15:49
 *
 */

package com.example.mobileproject4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobileproject4a.data.local.models.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}