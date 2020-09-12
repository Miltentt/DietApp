package com.example.myapplication.main.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.edamamResponse.CuisineTypeEnum
import com.example.myapplication.models.edamamResponse.DietEnum
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.models.edamamResponse.MealTypeEnum
import com.example.myapplication.repositories.RecipeRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class Meal_Recipe_SharedViewModel @Inject constructor(val recipeRepository: RecipeRepository) :ViewModel() {

    private var liveData = MutableLiveData<ArrayList<EdamamResponse.Hit.Recipe>>()
    private var recipelist = ArrayList<EdamamResponse.Hit.Recipe>()
    private var disposables : CompositeDisposable = CompositeDisposable()
    val recipearray : (EdamamResponse) -> Unit = { it->

        for(x in 0 until it.hits.size)
        {
            recipelist.add(it.hits.get(x).recipe)
        }
        liveData.value = recipelist
            Log.i("xd",recipelist.get(0).label)
    }


    fun getRecipes(mealtype : String, cuisine : String,diet : String)
    {
        var diet_enum : DietEnum?
        var cuisine_enum : CuisineTypeEnum?
        if(cuisine=="All the cuisines")
        {
            cuisine_enum = null
        }
        else
        {
            cuisine_enum= CuisineTypeEnum.valueOf(cuisine)
        }
        if(diet=="No diet")
        {
            diet_enum = null
        }
        else
        {
            diet_enum = DietEnum.valueOf(diet)
        }

      disposables.add(recipeRepository.loadRecipes(MealTypeEnum.valueOf(mealtype).name,null,null)
            .subscribe({recipearray(it)},{Log.i("xd","didnt work")}))

    }

    fun returnRecipeLiveData(): LiveData<ArrayList<EdamamResponse.Hit.Recipe>>
    {
        return liveData
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}