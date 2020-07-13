package com.example.myapplication.DI


import android.app.Application
import androidx.room.Room
import com.example.myapplication.Room.User_DAO
import com.example.myapplication.Room.User_Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule  {
@Singleton
@Provides
 fun provideRetrofitInstance() : Retrofit
    {
        return  Retrofit.Builder().baseUrl("xd")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


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


}