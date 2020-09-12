package com.example.myapplication.di


import android.app.Application
import androidx.room.Room

import com.example.myapplication.SessionManager
import com.example.myapplication.repositories.Repository
import com.example.myapplication.room.UserDAO
import com.example.myapplication.room.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule  {
    
@Singleton
@Provides
fun provideRoom(application: Application) : UserDatabase
{
    return Room.databaseBuilder(application,UserDatabase::class.java,"test").build()
}
@Singleton
@Provides
fun provideDao (userDatabase: UserDatabase) : UserDAO
{
    return userDatabase.getUserDAO()
}
fun provideRepo(userDatabase: UserDatabase) : Repository {
    return Repository(userDatabase.getUserDAO())
}
fun provideSessionManager() : SessionManager
{
    return SessionManager()
}

}