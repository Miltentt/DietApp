package com.example.myapplication.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.Model.User
import io.reactivex.Single


import java.util.*

@Dao
interface User_DAO {

    @Insert
    fun insertUser(vararg user:User)

@Query("SELECT * FROM User WHERE username LIKE :username")
fun loadUser(username : String) : Single<User>





}