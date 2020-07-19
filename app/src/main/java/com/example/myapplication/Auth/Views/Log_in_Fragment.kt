package com.example.myapplication.Auth.Views

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Model.User
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
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
    }

    fun authenticateUser()
    {
     authViewmodel.loadUser(username.toString()).subscribe(object : SingleObserver<User>
     {
         override fun onSuccess(t: User?) {
           password.toString().equals(t?.password)
             Log.e("xd","JEST USER")
         }

         override fun onSubscribe(d: Disposable?) {
             TODO("Not yet implemented")
         }

         override fun onError(e: Throwable?) {
             Log.e("xd","no user")
         }

     })



    }




}