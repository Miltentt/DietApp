package com.example.myapplication.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myapplication.util.TypeConverter
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @TypeConverters(TypeConverter::class)
    val ingredients: List<String>,
    @TypeConverters(TypeConverter::class)
    val nutrients: List<String>,
    val url: String,
    val calories: String,
    val servings: String,
    val mealType: String,
    val label: String,
    val photo: String,
    var favourite: Boolean

) : Parcelable {


}