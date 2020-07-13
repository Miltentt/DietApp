package com.example.myapplication.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.Model.User

@Dao
interface User_DAO {

    @Insert
    fun insertUser(vararg user:User)
@Query("SELECT * FROM user WHERE id=:id")
fun loadUser(id : Int)

}