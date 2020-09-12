package com.example.myapplication.retrofit


import com.example.myapplication.models.edamamResponse.EdamamResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface EdamamApi {

    @GET("search")
    fun searchRecipe(
        @Query("q") query: String,
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Query("from") from: Int,
        @Query("to") to: Int?,
        @Query("mealType") mealtype: String?,
        @Query("cuisineType") cuisineType: String?,
        @Query("diet") diet: String?
    ): Single<EdamamResponse>
}