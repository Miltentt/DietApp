package com.example.myapplication.room

import androidx.room.*
import com.example.myapplication.models.Recipe
import io.reactivex.Flowable

@Dao
interface RecipeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Throws(IllegalArgumentException::class)

    fun insertRecipe(vararg recipe: Recipe)

    @Query("SELECT * FROM Recipe WHERE mealType LIKE :mealtype AND favourite LIKE :boolean")
    fun loadRecipes(mealtype : String, boolean: Boolean=false): Flowable<List<Recipe>>

    @Query("SELECT * FROM Recipe WHERE mealType LIKE :mealtype AND favourite LIKE :boolean")
    fun loadFavourites(mealtype : String, boolean: Boolean=true): Flowable<List<Recipe>>

    @Query("DELETE  FROM Recipe WHERE label LIKE :label AND favourite LIKE :boolean ")
    fun deleteFavourite(label: String,boolean: Boolean=true )


}