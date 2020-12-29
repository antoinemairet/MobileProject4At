package com.example.mobileproject4a.injection

import com.example.mobileproject4a.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// just declare it
val presentationModule : Module = module {
    factory { MainViewModel() }
}