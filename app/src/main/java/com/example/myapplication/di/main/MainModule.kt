package com.example.myapplication.di.main

import android.app.Application
import androidx.room.Room
import com.example.myapplication.retrofit.EdamamApi
import com.example.myapplication.room.RecipeDAO
import com.example.myapplication.room.RecipeDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class MainModule {



    @Provides
    fun provideRetrofitInstance() : Retrofit
    {
        return  Retrofit.Builder().
        baseUrl("https://api.edamam.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provideEdamamApi(retrofit : Retrofit) : EdamamApi
    {
        return retrofit.create(EdamamApi::class.java)
    }

    @Provides
    fun provideRecipesDatabase(application: Application) : RecipeDatabase
    {
        return Room.databaseBuilder(application, RecipeDatabase::class.java,"recipes").build()
    }

    @Provides
    fun provideRecipesDAO(db: RecipeDatabase) : RecipeDAO
    {
        return db.getRecipeDAO()
    }

}

