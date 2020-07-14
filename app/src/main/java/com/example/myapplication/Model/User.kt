package com.example.myapplication.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User constructor(
                            @PrimaryKey(autoGenerate = true)
                            val id : Int =0,
                            val username : String,
                            val password : String,
                            val weight : Int,
                            val height : Int,
                            val age : Int)
{

}
