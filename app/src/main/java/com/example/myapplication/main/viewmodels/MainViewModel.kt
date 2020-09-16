package com.example.myapplication.main.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.RecipeMealType
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.repositories.RecipeRepository
import com.example.myapplication.retrofit.EdamamApi
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(private val reciperepository: RecipeRepository) : ViewModel() {

    fun loadRecipes(mealtype: String) : LiveData<List<RecipeMealType>>
    {
        return LiveDataReactiveStreams.fromPublisher(reciperepository.loadRecipes(mealtype))
    }


}