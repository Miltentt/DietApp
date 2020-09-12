package com.example.myapplication.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After

open class User_Database_Test {

    private val User_Database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),UserDatabase::class.java).allowMainThreadQueries()
        .build()

    fun getDao () : UserDAO
    {
return User_Database.getUserDAO()
    }


@After
    public fun finish()
    {
        User_Database.close()
    }


}