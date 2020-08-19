package com.example.myapplication.Auth.Views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Model.User
import com.example.myapplication.R

import dagger.android.support.DaggerFragment
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.android.synthetic.main.fragment_log_in.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class New_User_Fragment : DaggerFragment() {
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var authViewmodel: Auth_ViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[Auth_ViewModel::class.java]
        button.setOnClickListener({ v -> createUser() })

    }

    fun createUser() {
        authViewmodel.loadUser(create_username.text.toString())
            .subscribe(object : SingleObserver<User> {


                override fun onSuccess(t: User) {
                    Toast.makeText(context, "Username already extists", Toast.LENGTH_SHORT).show()

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                       try {
                           authViewmodel.addUser(
                               create_username.text.toString(),
                               create_password.text.toString(),
                               Integer.parseInt(weight.text.toString()),
                               Integer.parseInt(height.text.toString()),
                               Integer.parseInt(age.text.toString()),
                               spinner.selectedItem.toString(),
                               spinner2.selectedItem.toString())
                           activity?.supportFragmentManager?.popBackStackImmediate();
                       }
                       catch (e : Throwable)
                       {
                           Toast.makeText(context, "Fill all the fields correctly", Toast.LENGTH_SHORT).show()
                       }



                   }
                })


         }

    }
