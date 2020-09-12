package com.example.myapplication.Auth.Views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.View.MainActivity
import com.example.myapplication.R
import com.example.myapplication.Util.Resource
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class AuthActivity : DaggerAppCompatActivity()
{
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var authViewmodel: Auth_ViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[Auth_ViewModel::class.java]
        supportFragmentManager.beginTransaction()
            .replace(R.id.new_user, Log_in_Fragment())
            .commit()

        authViewmodel.observeUserState().observe({lifecycle},
            {t-> when(t)
            {
                is Resource.Success ->  {finish(); startActivity(Intent(this, MainActivity::class.java))}
                is Resource.Error -> Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }})
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.newuser -> {
              supportFragmentManager.beginTransaction()
                  .replace(R.id.new_user, New_User_Fragment())
                  .addToBackStack(null)
                  .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }



}


