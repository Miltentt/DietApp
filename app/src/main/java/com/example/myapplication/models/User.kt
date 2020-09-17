package com.example.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var username: String,
    val password: String,
    var weight: Int,
    val height: Int,
    var age: Int,
    val sex: String,
    var exercise: Double
) {

    override fun equals(other: Any?): Boolean {
        if (other == null)
            return false
        if (other::class != User::class)
            return false
        val user = other as User


        return user.username == username && user.password == password
    }

    override fun hashCode(): Int {
        return id
    }
}
