package com.example.myapplication.Main.View

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.ViewModel.Main_ViewModel
import com.example.myapplication.Model.User
import com.example.myapplication.R
import com.example.myapplication.Session_Manager
import com.example.myapplication.Util.Resource
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main1.*
import javax.inject.Inject


class MainActivity :  DaggerAppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    @Inject
    lateinit var sessionManager : Session_Manager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        observeUserState()
        setupActonBar(navController,drawerLayout)
        setupSideAction(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main1, menu)
        return true
    }



    private fun setupActonBar(navcontroller : NavController, drawerLayout: DrawerLayout)
    {
        NavigationUI.setupActionBarWithNavController(this,navcontroller,drawerLayout)

    }
    private fun setupSideAction(navcontroller: NavController)
    {
        nav_view.let {
            NavigationUI.setupWithNavController(it,navcontroller)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navigated = NavigationUI.onNavDestinationSelected(item!!, navController)
        if(item.itemId==R.id.logout) sessionManager.logout()
        return navigated || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.nav_host_fragment),drawer_layout)
    }

    private fun observeUserState()
    {
        sessionManager.returnUser().observe({lifecycle},{t-> if(t is Resource.Logout) finish()})
    }


}