package com.example.myapplication.DI


import android.app.Application
import androidx.room.Room

import com.example.myapplication.Session_Manager
import com.example.myapplication.Repository.Repository
import com.example.myapplication.Room.User_DAO
import com.example.myapplication.Room.User_Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule  {
    
@Singleton
@Provides
fun provideRoom(application: Application) : User_Database
{
    return Room.databaseBuilder(application,User_Database::class.java,"test").build()
}
@Singleton
@Provides
fun provideDao (userDatabase: User_Database) : User_DAO
{
    return userDatabase.getUserDAO()
}
fun provideRepo(userDatabase: User_Database) : Repository {
    return Repository(userDatabase.getUserDAO())
}
fun provideSessionManager() : Session_Manager
{
    return Session_Manager()
}

}