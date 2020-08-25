package com.example.myapplication.Repository

import com.example.myapplication.Model.Edamam_Response.Cuisine_Type_Enum
import com.example.myapplication.Model.Edamam_Response.Diet_Enum
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.Model.Edamam_Response.mealType_Enum
import com.example.myapplication.Retrofit.Edamam_Api
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Recipe_Repository @Inject constructor(val edamamApi: Edamam_Api) {

    fun loadRecipes(mealtype : mealType_Enum, cuisine : Cuisine_Type_Enum?, diet : Diet_Enum?): Single<Edamam_Response>
    {
     return  edamamApi.searchRecipe("chicken","5f0d0995","4541a1a4b79b44352a7172ef1b6ff013",0,1,mealtype,cuisine,diet)
         .subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())

    }




}