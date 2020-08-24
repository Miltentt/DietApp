package com.example.myapplication.Auth.Views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.R
import dagger.android.support.DaggerAppCompatActivity


class AuthActivity : DaggerAppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.new_user, Log_in_Fragment())
            .commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.layout.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
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


