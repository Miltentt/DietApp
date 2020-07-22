package com.example.myapplication.DI.Main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelKey
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.ViewModel.Main_ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class Main_ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(Main_ViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindViewModel(mainViewmodel: Main_ViewModel): ViewModel

    @SuppressWarnings("unused")
    @Binds
    abstract fun bind_ViewModel(ViewModelsProviderFactory: ViewModelsProviderFactory): ViewModelProvider.Factory
}