package com.example.myapplication.Auth.Views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.Auth.ViewModels.ViewModelsProviderFactory
import com.example.myapplication.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject


class AuthActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
supportFragmentManager.beginTransaction()
    .replace(R.id.nav_host_fragment,New_User_Fragment())
    .commit()
    }
}


