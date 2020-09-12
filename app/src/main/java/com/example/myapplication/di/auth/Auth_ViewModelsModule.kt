package com.example.myapplication.di.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.auth.viewmodels.AuthViewModel
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.di.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class Auth_ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindViewModel(authViewmodel: AuthViewModel) : ViewModel

    @SuppressWarnings("unused")
    @Binds
    abstract fun bind_ViewModel(ViewModelsProviderFactory: ViewModelsProviderFactory) : ViewModelProvider.Factory
}