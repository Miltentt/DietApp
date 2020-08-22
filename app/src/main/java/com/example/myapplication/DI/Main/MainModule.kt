package com.example.myapplication.DI.Main

import com.example.myapplication.Retrofit.Edamam_Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class MainModule {

    @Provides
    fun provideRetrofitInstance() : Retrofit
    {
        return  Retrofit.Builder().
        baseUrl("https://api.edamam.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun provide_Edamam_Api(retrofit : Retrofit) : Edamam_Api
    {
        return retrofit.create(Edamam_Api::class.java)
    }


}

