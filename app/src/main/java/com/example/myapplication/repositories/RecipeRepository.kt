package com.example.myapplication.repositories

import android.annotation.SuppressLint
import android.util.Log
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.retrofit.EdamamApi
import com.example.myapplication.room.RecipeDAO
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeRepository @Inject constructor(val edamamApi: EdamamApi, val recipeDAO: RecipeDAO) {

    fun searchRecipes(
        query: String,
        mealtype: String,
        cuisine: String?,
        diet: String?
    ): Single<EdamamResponse> {
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

    fun loadRecipes(mealtype: String): Flowable<List<Recipe>> {
        return recipeDAO.loadRecipes(mealtype)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("CheckResult")
    fun insertRecipes(recipe: Recipe) {
        Completable.fromAction { recipeDAO.insertRecipe(recipe) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }


    fun loadFavourites(mealtype: String): Flowable<List<Recipe>> {
        return recipeDAO.loadFavourites(mealtype)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    fun deleteRecipe(label: String,boolean: Boolean=true)
    {
        Completable.fromAction { recipeDAO.deleteFavourite(label,boolean) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}