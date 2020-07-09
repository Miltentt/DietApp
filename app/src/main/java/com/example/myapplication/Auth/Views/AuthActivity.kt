package com.example.myapplication.Auth.Views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.Auth.ViewModels.ViewModelsProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class AuthActivity : DaggerAppCompatActivity() {

 private lateinit var authViewmodel : Auth_ViewModel

    @Inject
 lateinit var  viewmodelprovider : ViewModelsProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[Auth_ViewModel::class.java]



    }
}


