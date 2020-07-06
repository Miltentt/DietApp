package com.example.myapplication.DI

import com.example.myapplication.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun ContributeAuthActivity() : AuthActivity
}