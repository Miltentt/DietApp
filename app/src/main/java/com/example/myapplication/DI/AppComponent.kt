package com.example.myapplication.DI

import com.example.myapplication.BaseApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = arrayOf(AndroidSupportInjectionModule::class)

)
interface AppComponent : AndroidInjector<BaseApplication> {



}