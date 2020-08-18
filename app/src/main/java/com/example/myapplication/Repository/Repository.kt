package com.example.myapplication.Repository

import com.example.myapplication.Model.User
import com.example.myapplication.Room.User_DAO
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import javax.inject.Inject

class Repository @Inject constructor(val userDao: User_DAO) {




    fun addUser( username : String,  password : String,  weight : Int,  height : Int,  age : Int, sex :String,exercise : Double)  {

   Completable.fromAction({

    userDao.insertUser(
        User(
            username = username,
            password = password,
            weight = weight,
            height = height,
            age = age,
            sex=sex,
        exercise = exercise)
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