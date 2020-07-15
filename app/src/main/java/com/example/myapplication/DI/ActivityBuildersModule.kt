package com.example.myapplication.DI

import com.example.myapplication.Auth.Views.AuthActivity
import com.example.myapplication.DI.Auth.Auth_ViewModelsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class,Auth_ViewModelsModule::class])
    abstract fun ContributeAuthActivity() : AuthActivity



}