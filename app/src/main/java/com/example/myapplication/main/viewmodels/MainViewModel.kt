package com.example.myapplication.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Recipe
import com.example.myapplication.repositories.RecipeRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val reciperepository: RecipeRepository) : ViewModel() {

    fun loadRecipes(mealtype: String) : LiveData<List<Recipe>>
    {
        return LiveDataReactiveStreams.fromPublisher(reciperepository.loadRecipes(mealtype))
    }


}