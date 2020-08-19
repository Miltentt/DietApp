package com.example.myapplication.Model

import android.icu.util.Measure

data class Edamam_Recipe constructor(
    val q : String,
    val from : Int,
    val to : Int,
    val hits : Array<Hit>
) {

   data class Hit constructor(
 val recipe : Recipe
 ) {

       data class Recipe constructor(
           val uri: String,
           val label: String,
           val image: String,
           val url: String,
           val yield: String,
           val calories: Float,
           val totalweight : Float,
           val ingredients : Array<Ingredient>,
           val totalNutrients : Array<NutrientInfo>
       )
       {
           data class NutrientInfo constructor(
               val uri : String,
               val label : String,
               val quantity: Float,
               val unit : String
           )
           data class Ingredient constructor(
               val foodid : String,
               val quantity : Float,
               val measure : Ingredient.Measure,
               val weight : Float,
               val food: Food
           )
           {
               data class  Food constructor(
                   val foodid: String,
                   val label: String
               )
               data class Measure constructor(
                   val uri: String,
                   val label: String
               )
           }



       }
   }
}