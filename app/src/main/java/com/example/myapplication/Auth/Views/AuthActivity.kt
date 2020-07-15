package com.example.myapplication.Auth.Views

import android.app.Activity
import android.os.Bundle
import com.example.myapplication.R
import dagger.android.AndroidInjector

import dagger.android.support.DaggerAppCompatActivity


class AuthActivity : DaggerAppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, New_User_Fragment())
            .commit()
    }




}


