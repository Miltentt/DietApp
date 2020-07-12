package com.example.myapplication.DI


import android.app.Application
import androidx.room.Room
import com.example.myapplication.Room.User_Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule constructor(val application: Application) {
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
fun provideApplication() : Application
{
    return application
}

@Singleton
@Provides
fun provideRoom() : User_Database
{
    return Room.databaseBuilder(application,User_Database::class.java,"test").build()
}




}