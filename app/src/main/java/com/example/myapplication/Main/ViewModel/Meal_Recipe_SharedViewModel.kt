package com.example.myapplication.Main.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.Edamam_Response.Cuisine_Type_Enum
import com.example.myapplication.Model.Edamam_Response.Diet_Enum
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.Model.Edamam_Response.mealType_Enum
import com.example.myapplication.Repository.Recipe_Repository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class Meal_Recipe_SharedViewModel @Inject constructor(val recipeRepository: Recipe_Repository) :ViewModel() {

    private var liveData = MutableLiveData<ArrayList<Edamam_Response.Hit.Recipe>>()
    private var recipelist = ArrayList<Edamam_Response.Hit.Recipe>()
    private var disposables : CompositeDisposable = CompositeDisposable()
    val recipearray : (Edamam_Response) -> Unit = { it->

        for(x in 0 until it.hits.size)
        {
            recipelist.add(it.hits.get(x).recipe)
        }
        liveData.value = recipelist
            Log.i("xd",recipelist.get(0).label)
    }


    fun getRecipes(mealtype : String, cuisine : String,diet : String)
    {
        var diet_enum : Diet_Enum?
        var cuisine_enum : Cuisine_Type_Enum?
        if(cuisine=="All the cuisines")
        {
            cuisine_enum = null
        }
        else
        {
            cuisine_enum= Cuisine_Type_Enum.valueOf(cuisine)
        }
        if(diet=="No diet")
        {
            diet_enum = null
        }
        else
        {
            diet_enum = Diet_Enum.valueOf(diet)
        }

      disposables.add(recipeRepository.loadRecipes(mealType_Enum.valueOf(mealtype).name,null,null)
            .subscribe({recipearray(it)},{Log.i("xd","didnt work")}))

    }

    fun returnRecipeLiveData(): LiveData<ArrayList<Edamam_Response.Hit.Recipe>>
    {
        return liveData
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}