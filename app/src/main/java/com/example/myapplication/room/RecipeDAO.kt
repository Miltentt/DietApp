package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.models.RecipeMealType
import io.reactivex.Flowable

@Dao
interface RecipeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @Throws(IllegalArgumentException::class)

    fun insertRecipe(vararg recipe: RecipeMealType)

    @Query("SELECT * FROM RecipeMealType WHERE mealType LIKE :mealtype")
    fun loadRecipes(mealtype : String): Flowable<List<RecipeMealType>>


}