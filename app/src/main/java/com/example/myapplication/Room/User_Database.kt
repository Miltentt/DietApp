package com.example.myapplication.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.Model.User

@Database(entities = [User::class], version = 1)
abstract class User_Database : RoomDatabase() {

    abstract fun getUserDAO() : User_DAO

}