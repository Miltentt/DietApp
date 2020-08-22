package com.example.myapplication.Main.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.Diet_Enum
import com.example.myapplication.Model.Edamam_Response
import com.example.myapplication.Model.mealType_Enum
import com.example.myapplication.Repository.Recipe_Repository
import javax.inject.Inject

class Meal_ViewModel @Inject constructor(val recipeRepository: Recipe_Repository) :ViewModel() {


    fun getRecipes(mealtype : String, cuisine : String?,diet : String?) : LiveData<Edamam_Response>
    {


       return LiveDataReactiveStreams.fromPublisher(
        recipeRepository.loadRecipes(mealType_Enum.valueOf(mealtype),null,null)
            .toFlowable()
            )



    }





}