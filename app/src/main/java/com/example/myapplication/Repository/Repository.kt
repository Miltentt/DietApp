package com.example.myapplication.Repository

import com.example.myapplication.Model.User
import com.example.myapplication.Room.User_DAO
import javax.inject.Inject

class Repository @Inject constructor(val userDao: User_DAO) {



    fun addUser( username : String,  password : String,  weight : Int,  height : Int,  age : Int) {
userDao.insertUser(User(username = username,password = password,weight = weight,height = height,age = age))

    }


}