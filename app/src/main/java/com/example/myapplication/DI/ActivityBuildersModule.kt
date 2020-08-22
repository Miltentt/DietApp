package com.example.myapplication.DI

import com.example.myapplication.Auth.Views.AuthActivity
import com.example.myapplication.DI.Auth.Auth_ViewModelsModule
import com.example.myapplication.DI.Main.MainModule
import com.example.myapplication.DI.Main.Main_ViewModelsModule
import com.example.myapplication.Main.View.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class,Auth_ViewModelsModule::class])
    abstract fun ContributeAuthActivity() : AuthActivity

    @ContributesAndroidInjector(modules = [FragmentsBuilderModule::class,Main_ViewModelsModule::class,MainModule::class])
    abstract fun ContributeMainActivity() : MainActivity

}