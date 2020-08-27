package com.example.myapplication.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.Model.User
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.IllegalArgumentException


import java.util.*

@Dao
interface User_DAO {

    @Insert
    @Throws(IllegalArgumentException::class)
    fun insertUser(vararg user:User)  : Completable

@Query("SELECT * FROM User WHERE username LIKE :username")
fun loadUser(username : String) : Single<User>

    @Update
    fun updateUser(vararg  user: User) : Completable

    @Query("SELECT * FROM User WHERE username LIKE :username AND password LIKE :password" )
    fun authenticateUser(username : String,password : String) : Single<User>



}