package com.example.myapplication.di

import com.example.myapplication.auth.views.AuthActivity
import com.example.myapplication.di.auth.Auth_ViewModelsModule
import com.example.myapplication.di.main.MainModule
import com.example.myapplication.di.main.MainViewModelsModule
import com.example.myapplication.main.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class,Auth_ViewModelsModule::class])
    abstract fun ContributeAuthActivity() : AuthActivity

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class,MainViewModelsModule::class,MainModule::class])
    abstract fun ContributeMainActivity() : MainActivity

}