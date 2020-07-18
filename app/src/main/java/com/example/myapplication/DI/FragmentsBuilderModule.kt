package com.example.myapplication.DI

import com.example.myapplication.Auth.Views.Log_in_Fragment
import com.example.myapplication.Auth.Views.New_User_Fragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun new_user_fragment() : New_User_Fragment
@ContributesAndroidInjector
abstract fun log_in_fragment() : Log_in_Fragment


}