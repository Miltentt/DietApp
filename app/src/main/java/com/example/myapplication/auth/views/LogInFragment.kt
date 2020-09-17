package com.example.myapplication.auth.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.auth.viewmodels.AuthViewModel
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLogInBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LogInFragment : DaggerFragment() {
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var authViewmodel: AuthViewModel
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[AuthViewModel::class.java]

        binding.login.setOnClickListener { authenticateUser() }

    }


    private fun authenticateUser() {

        authViewmodel.authenticateUser(
            binding.username.text.toString(),
            binding.password.text.toString()
        )


    }
}