package com.example.myapplication

import com.example.myapplication.DI.AppComponent
import com.example.myapplication.DI.AppModule_ProvideRetrofitInstanceFactory.create
import com.example.myapplication.DI.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
return DaggerAppComponent.builder().application(this).build()
    }
}