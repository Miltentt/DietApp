package com.example.myapplication.Model

import androidx.room.Entity

@Entity
data class User constructor(val username : String,val password : String, val weight : Int, val height : Int,val age : Int)
