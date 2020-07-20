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

    public fun addUser(username : String,  password : String,  weight : Int,  height : Int,  age : Int) {
        repository.addUser(username,  password ,  weight,  height ,  age)
    }
    fun loadUser(username: String) : Single<User>
    {
        return    repository.loadUser(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }




}