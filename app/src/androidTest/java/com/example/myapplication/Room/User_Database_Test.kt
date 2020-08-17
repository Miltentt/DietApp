package com.example.myapplication.Room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before

open class User_Database_Test {

    private val User_Database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),User_Database::class.java).allowMainThreadQueries()
        .build()

    fun getDao () : User_DAO
    {
return User_Database.getUserDAO()
    }


@After
    public fun finish()
    {
        User_Database.close()
    }


}