package com.example.myapplication.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.di.ViewModelKey
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.viewmodels.*
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

    @Binds
    @IntoMap
    @ViewModelKey(RecipeViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindRecipeViewModel(recipeViewModel: RecipeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    @SuppressWarnings("unused")
    abstract fun bindMenuViewModel(menuViewModel: MenuViewModel) : ViewModel


}