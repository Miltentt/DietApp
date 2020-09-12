package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.BaseApplication
import com.example.myapplication.di.main.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidSupportInjectionModule::class,ActivityBuildersModule::class,AppModule::class,MainModule::class)

)
interface AppComponent : AndroidInjector<BaseApplication>{
@Component.Builder
interface Builder
{
    @BindsInstance
    fun application(application : Application) : Builder
    fun build() : AppComponent
}


}