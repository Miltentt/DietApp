package com.example.myapplication.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.RecipeMealType
import com.example.myapplication.repositories.RecipeRepository
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val reciperepository: RecipeRepository) : ViewModel() {

fun loadRecipes(mealtype: String) : LiveData<List<RecipeMealType>>
{
    return LiveDataReactiveStreams.fromPublisher(reciperepository.loadRecipes(mealtype))
}
}