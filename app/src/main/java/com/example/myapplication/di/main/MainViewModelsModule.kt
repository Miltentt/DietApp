package com.example.myapplication.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.viewmodels.EditUserViewModel
import com.example.myapplication.main.viewmodels.MainViewModel
import com.example.myapplication.main.viewmodels.Meal_Recipe_SharedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindViewModel(mainViewmodel: MainViewModel): ViewModel

    @SuppressWarnings("unused")
    @Binds
    abstract fun bindViewModelFactory(ViewModelsProviderFactory: ViewModelsProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(Meal_Recipe_SharedViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindMealViewModel(mealViewmodel: Meal_Recipe_SharedViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditUserViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindEditViewModel(mealViewmodel: EditUserViewModel) : ViewModel

}