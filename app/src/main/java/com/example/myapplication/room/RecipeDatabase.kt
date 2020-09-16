package com.example.myapplication.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.models.RecipeMealType

@Database(entities = [RecipeMealType::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun getRecipeDAO() : RecipeDAO
}
