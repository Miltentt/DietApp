package com.example.myapplication.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.User
import com.example.myapplication.repositories.Repository
import com.example.myapplication.SessionManager
import com.example.myapplication.util.Resource
import javax.inject.Inject

class EditUserViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    val repository: Repository
) : ViewModel() {

    fun loaduser(): LiveData<Resource<User>> {
        return sessionManager.returnUser()
    }

    fun returnExercise(amount: Double): String {
        var stringamount = ""
        when (amount) {
            1.2 -> stringamount = "Little to no exercise"
            1.375 -> stringamount = "Light exercise (1–3 days per week)"
            1.55 -> stringamount = "Moderate exercise (3–5 days per week)"
            1.725 -> stringamount = "Heavy exercise (6–7 days per week)"
            1.9 -> stringamount = "Very heavy exercise (twice per day, extra heavy workouts)"
        }
        return stringamount
    }

    fun updateUser(
        id: Int,
        username: String,
        password: String,
        weight: Int,
        height: Int,
        age: Int,
        sex: String,
        exercise: String
    ) {
        val exerciseInt: Double = when (exercise) {
            "Little to no exercise" -> 1.2
            "Light exercise (1–3 days per week)" -> 1.375
            "Moderate exercise (3–5 days per week)" -> 1.55
            "Heavy exercise (6–7 days per week)" -> 1.725
            "Very heavy exercise (twice per day, extra heavy workouts)" -> 1.9
            else -> throw IllegalArgumentException("invalid name")
        }
        val user = User(id, username, password, weight, height, age, sex, exerciseInt)
        repository.updateUser(user)
        sessionManager.authenticateUser(MutableLiveData<Resource<User>>(Resource.Success(user)))

    }

}