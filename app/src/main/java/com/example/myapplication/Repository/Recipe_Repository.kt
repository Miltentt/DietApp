package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.Model.Edamam_Recipe
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.Retrofit.Edamam_Api
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Recipe_Repository @Inject constructor(val edamamApi: Edamam_Api) {

    fun loadRecipes(): Single<Edamam_Response>
    {
Log.i("xd",edamamApi.toString())
     return  edamamApi.searchRecipe("chicken","5f0d0995","4541a1a4b79b44352a7172ef1b6ff013",0,1).subscribeOn(
         Schedulers.io())
         .subscribeOn(AndroidSchedulers.mainThread())

    }




}