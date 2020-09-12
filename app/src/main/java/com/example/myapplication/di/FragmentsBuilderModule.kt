package com.example.myapplication.di

import com.example.myapplication.auth.views.LogInFragment
import com.example.myapplication.auth.views.NewUserFragment
import com.example.myapplication.main.views.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun newUserFragment() : NewUserFragment
@ContributesAndroidInjector
abstract fun logInFragment() : LogInFragment

    @ContributesAndroidInjector
    abstract fun menuFragment() : FragmentMenu
    @ContributesAndroidInjector
    abstract fun mealFragment() : FragmentMeal
    @ContributesAndroidInjector
    abstract fun recipesFragment() : FragmentRecipes
    @ContributesAndroidInjector
    abstract fun userFragment() : FragmentEditUser
    @ContributesAndroidInjector
    abstract fun recipeFragment() : FragmentRecipe


}