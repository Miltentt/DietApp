package com.example.myapplication.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @SuppressWarnings("unused")
    @Binds
    abstract fun bindViewModel(ViewModelsProviderFactory: ViewModelsProviderFactory) : ViewModelProvider.Factory

}