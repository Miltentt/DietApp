package com.example.myapplication.Auth.Views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.View.MainActivity
import com.example.myapplication.Model.User
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_create_user.*

import kotlinx.android.synthetic.main.fragment_log_in.*
import javax.inject.Inject

class Log_in_Fragment : DaggerFragment() {
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    private lateinit var authViewmodel : Auth_ViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_log_in,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[Auth_ViewModel::class.java]
        login.setOnClickListener({v->authenticateUser()})
    }

    fun authenticateUser()
    {

     authViewmodel.loadUser(username.text.toString()).subscribe(object : SingleObserver<User>
     {


         override fun onSuccess(t: User) {
             if( password.text.toString().equals(t.password))
             {
                 authViewmodel.authenticateuser(t)
val intent = Intent(context,MainActivity::class.java)
                 startActivity(intent)
             }
            else
             {
                 Toast.makeText(context, "Wrong username or password", Toast.LENGTH_SHORT).show()
             }
         }

         override fun onSubscribe(d: Disposable) {

         }

         override fun onError(e: Throwable) {
             Log.e("xd","no user")
         }

     })



    }




}