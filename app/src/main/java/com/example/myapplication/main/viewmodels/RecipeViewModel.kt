package com.example.myapplication.main.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.repositories.RecipeRepository
import io.reactivex.Completable
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModel() {

    fun insertRecipe(recipe: Recipe)
    {
        recipeRepository.insertRecipes(recipe)
    }

    fun deleteRecipe(label: String,boolean: Boolean=true)
    {
        recipeRepository.deleteRecipe(label,boolean)
    }

}