package com.example.mobileproject4a.injection

import com.example.mobileproject4a.data.repository.UserRepository
import com.example.mobileproject4a.domain.usecase.CreateUserUseCase
import com.example.mobileproject4a.presentation.main.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// just declare it
val presentationModule : Module = module {
    factory { MainViewModel(get()) }
}

val domaineModule : Module = module {
    factory { CreateUserUseCase(get()) }
}

val dataModule : Module = module {
    single { UserRepository() }
}
