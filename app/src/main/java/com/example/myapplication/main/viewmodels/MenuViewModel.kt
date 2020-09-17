package com.example.myapplication.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.repositories.RecipeRepository
import javax.inject.Inject

class MenuViewModel @Inject constructor(private val reciperepository: RecipeRepository) :
    ViewModel() {

    fun returnRecipeLiveData(mealtype: String): LiveData<List<Recipe>> {

        return LiveDataReactiveStreams.fromPublisher(reciperepository.loadRecipes(mealtype))
    }
}