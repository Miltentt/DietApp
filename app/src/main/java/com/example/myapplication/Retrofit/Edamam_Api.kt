package com.example.myapplication.Retrofit


import com.example.myapplication.Model.Cuisine_Type_Enum
import com.example.myapplication.Model.Diet_Enum
import com.example.myapplication.Model.Edamam_Response
import com.example.myapplication.Model.mealType_Enum
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Edamam_Api {

    @GET("search")
    fun searchRecipe(
        @Query("q") query: String,
        @Query("app_id") id: String,
        @Query("app_key") key: String,
        @Query("from") from: Int,
        @Query("to") to: Int?,
        @Query("mealtype") mealtype: mealType_Enum,
        @Query("cuisineType") cuisineTypeEnum: Cuisine_Type_Enum?,
        @Query("diet") dietEnum: Diet_Enum?
    ): Single<Edamam_Response>
}