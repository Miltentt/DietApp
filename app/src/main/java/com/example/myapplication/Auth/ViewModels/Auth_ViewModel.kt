package com.example.myapplication.Auth.ViewModels

import androidx.lifecycle.ViewModel
import com.example.myapplication.Repository.Repository
import javax.inject.Inject


class Auth_ViewModel  @Inject constructor(val repository: Repository) : ViewModel() {

    public fun addUser(username : String,  password : String,  weight : Int,  height : Int,  age : Int) {
        repository.addUser(username,  password ,  weight,  height ,  age)
    }


}