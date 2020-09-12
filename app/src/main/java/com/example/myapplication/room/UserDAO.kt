package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.models.User
import io.reactivex.Single

@Dao
interface UserDAO {

    @Insert
    @Throws(IllegalArgumentException::class)
    fun insertUser(vararg user: User)

    @Query("SELECT * FROM User WHERE username LIKE :username")
    fun loadUser(username: String): Single<User>

    @Update
    fun updateUser(vararg user: User)

    @Query("SELECT * FROM User WHERE username LIKE :username AND password LIKE :password")
    fun authenticateUser(username: String, password: String): Single<User>


}