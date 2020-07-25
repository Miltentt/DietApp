package com.example.myapplication.Main.View

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main1.*


class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        getActionBar()?.setDisplayHomeAsUpEnabled(true);
        getActionBar()?.setHomeButtonEnabled(true);
        setContentView(R.layout.activity_main1)
      init()
    }
  fun init()
  {
   val navcontroller = Navigation.findNavController(this,R.id.nav_host_fragment)
NavigationUI.setupActionBarWithNavController(this,navcontroller,drawer_layout)
      NavigationUI.setupWithNavController(nav_view,navcontroller)

  }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main1, menu)
        return true
    }
    }

