package com.example.myapplication.room


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.models.Recipe
import com.example.myapplication.util.TypeConverter

@TypeConverters(TypeConverter::class)
@Database(entities = [Recipe::class], version = 1)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun getRecipeDAO() : RecipeDAO
}
