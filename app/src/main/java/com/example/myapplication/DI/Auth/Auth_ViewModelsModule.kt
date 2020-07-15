package com.example.myapplication.DI.Auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelKey
import com.example.myapplication.DI.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class Auth_ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Auth_ViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindViewModel(authViewmodel: Auth_ViewModel) : ViewModel

    @SuppressWarnings("unused")
    @Binds
    abstract fun bind_ViewModel(ViewModelsProviderFactory: ViewModelsProviderFactory) : ViewModelProvider.Factory
}