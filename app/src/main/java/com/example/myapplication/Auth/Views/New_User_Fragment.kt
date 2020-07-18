package com.example.myapplication.Auth.Views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.R

import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.age
import kotlinx.android.synthetic.main.fragment_first.button
import kotlinx.android.synthetic.main.fragment_first.height
import kotlinx.android.synthetic.main.fragment_first.password
import kotlinx.android.synthetic.main.fragment_first.username
import kotlinx.android.synthetic.main.fragment_first.weight
import javax.inject.Inject

class New_User_Fragment : DaggerFragment()
{
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    private lateinit var authViewmodel : Auth_ViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_user, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[Auth_ViewModel::class.java]
button.setOnClickListener({v -> createUser()})

    }
    fun createUser()
    {
authViewmodel.addUser(
    username.text.toString(),
    password.text.toString(),
    Integer.parseInt(weight.text.toString()),
    Integer.parseInt(height.text.toString()),
    Integer.parseInt(age.text.toString())
)
        activity?.supportFragmentManager?.popBackStackImmediate();
    }
}