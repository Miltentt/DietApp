package com.example.myapplication.DI

import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Auth.ViewModels.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bind_ViewModel(ViewModelsProviderFactory: ViewModelsProviderFactory) : ViewModelProvider.Factory



}