package com.example.myapplication.repositories

import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.retrofit.EdamamApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeRepository @Inject constructor(val edamamApi: EdamamApi) {

    fun loadRecipes(query: String, mealtype: String, cuisine: String?, diet: String?): Single<EdamamResponse> {
        return edamamApi.searchRecipe(
            query,
            "5f0d0995",
            "c2777bd93d26a4ce5bd17caee04026d0",
            0,
            30,
            null,
            null,
            null
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}