package com.example.myapplication.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User constructor(
                            val username : String,
                            val password : String,
                            val weight : Int,
                            val height : Int,
                            val age : Int)
{
    @PrimaryKey(autoGenerate = true)
    val id = 0;
}
