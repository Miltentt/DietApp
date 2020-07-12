package com.example.myapplication.DI.Auth

import androidx.lifecycle.ViewModel
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
abstract class Auth_ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Auth_ViewModel::class)
    abstract fun bindViewModel(authViewmodel: Auth_ViewModel) : ViewModel
}