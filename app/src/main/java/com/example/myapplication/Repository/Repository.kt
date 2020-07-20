package com.example.myapplication.Repository

import com.example.myapplication.Model.User
import com.example.myapplication.Room.User_DAO
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Callable
import javax.inject.Inject

class Repository @Inject constructor(val userDao: User_DAO) {



    fun addUser( username : String,  password : String,  weight : Int,  height : Int,  age : Int) {
Completable.fromAction({

    userDao.insertUser(
        User(
            username = username,
            password = password,
            weight = weight,
            height = height,
            age = age
        )
    )
})
    .subscribeOn(Schedulers.io())
    .subscribe()


    }
    fun loadUser(username: String) : Single<User>
    {
      return userDao.loadUser(username)
    }


}