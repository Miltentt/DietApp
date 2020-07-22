package com.example.myapplication.Auth.ViewModels

import android.database.Observable
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.User
import com.example.myapplication.Repository.Repository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



import javax.inject.Inject


class Auth_ViewModel  @Inject constructor(val repository: Repository) : ViewModel() {

    public fun addUser(username : String,  password : String,  weight : Int,  height : Int,  age : Int,sex : String,exercise : String) {
var exerciseInt : Double
        when(exercise)
        {
            "Little to no exercise" -> exerciseInt=1.2
            "Light exercise (1–3 days per week)" -> exerciseInt=1.375
            "Moderate exercise (3–5 days per week)" -> exerciseInt=1.55
            "Heavy exercise (6–7 days per week)" ->  exerciseInt=1.725
            "Very heavy exercise (twice per day, extra heavy workouts)" ->exerciseInt=1.9
            else -> exerciseInt=0.0
        }



        repository.addUser(username,  password ,  weight,  height ,  age, sex,exerciseInt)
    }
    fun loadUser(username: String) : Single<User>
    {
        return    repository.loadUser(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }




}