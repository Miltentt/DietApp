package com.example.myapplication.Retrofit

import com.example.myapplication.Model.Edamam_Recipe
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
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
        @Query("to") to: Int?
    ): Single<Edamam_Response>
}