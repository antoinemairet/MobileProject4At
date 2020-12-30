package com.example.mobileproject4a.injection

import android.content.Context
import androidx.room.Room
import com.example.mobileproject4a.data.local.AppDatabase
import com.example.mobileproject4a.data.local.DatabaseDao
import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import com.example.mobileproject4a.domain.usecase.GetUserUseCase
import com.example.mobileproject4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

// just declare it
val presentationModule : Module = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule : Module = module {
    single { UserRepository(get()) }
    single{createDatabase(androidContext()) }
}
fun createDatabase(context: Context): DatabaseDao {
    val appDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
