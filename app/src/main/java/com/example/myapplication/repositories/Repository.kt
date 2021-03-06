package com.example.myapplication.repositories

import android.annotation.SuppressLint
import com.example.myapplication.models.User
import com.example.myapplication.room.UserDAO
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(val userDao: UserDAO) {

    @SuppressLint("CheckResult")
    fun addUser(
        username: String, password: String, weight: Int, height: Int, age: Int, sex: String,
        exercise: Double
    ) {

        Completable.fromAction {
            userDao.insertUser(
                User(
                    username = username,
                    password = password,
                    weight = weight,
                    height = height,
                    age = age,
                    sex = sex,
                    exercise = exercise
                )
            )
        }.subscribeOn(Schedulers.io())
            .subscribe {}
    }

    fun loadUser(username: String): Single<User> {
        return userDao.loadUser(username)
    }

    fun authenticateUser(username: String, password: String): Single<User> {
        return userDao.authenticateUser(username, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    @SuppressLint("CheckResult")
    fun updateUser(user: User) {
        Completable.fromAction {
            userDao.updateUser(user)
        }.subscribeOn(Schedulers.io())
            .subscribe {}
    }

}