package com.example.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.models.edamamResponse.EdamamResponse

@Entity
class RecipeMealType(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val recipe: EdamamResponse.Hit.Recipe,
    val mealType: String
) {


}