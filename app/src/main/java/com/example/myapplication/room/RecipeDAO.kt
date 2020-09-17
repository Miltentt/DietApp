package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.models.Recipe
import io.reactivex.Flowable

@Dao
interface RecipeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Throws(IllegalArgumentException::class)

    fun insertRecipe(vararg recipe: Recipe)

    @Query("SELECT * FROM Recipe WHERE mealType LIKE :mealtype")
    fun loadRecipes(mealtype : String): Flowable<List<Recipe>>


}