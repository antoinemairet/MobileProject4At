/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 20:32
 *
 */

package com.example.mobileproject4a.injection

import android.content.Context
import androidx.room.Room
import com.example.mobileproject4a.data.local.AppDatabase
import com.example.mobileproject4a.data.local.DatabaseDao
import com.example.mobileproject4a.data.remote.MovieAPI
import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import com.example.mobileproject4a.domain.usecase.GetUserUseCase
import com.example.mobileproject4a.presentation.createaccount.CreateAccountViewModel
import com.example.mobileproject4a.presentation.list.ListViewModel
import com.example.mobileproject4a.presentation.main.MainViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var movieApiInstance: MovieAPI? = null
private var gsonInstance: Gson? = null
// just declare it
val presentationModule : Module = module {
    factory { MainViewModel(get()) }
    factory { CreateAccountViewModel(get(), get())}
    factory { ListViewModel() }
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
fun getGson(): Gson? {
    if (gsonInstance == null) {
        gsonInstance = GsonBuilder().setLenient().create()
    }
    return gsonInstance
}
fun getMovieAPI(): MovieAPI? {
    if (movieApiInstance == null) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://imdb-api.com/")
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .build()
        movieApiInstance = retrofit.create(MovieAPI::class.java)
    }
    return movieApiInstance
}
