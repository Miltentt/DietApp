package com.example.myapplication.auth.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.auth.viewmodels.AuthViewModel
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.models.User
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCreateUserBinding
import dagger.android.support.DaggerFragment
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NewUserFragment : DaggerFragment() {
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var authViewmodel: AuthViewModel
    private lateinit var binding: FragmentCreateUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_user, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewmodel = ViewModelProviders.of(this, viewmodelprovider)[AuthViewModel::class.java]
        binding.button.setOnClickListener { createUser() }

    }

    private fun createUser() {
        authViewmodel.loadUser(binding.createUsername.text.toString())
            .subscribe(object : SingleObserver<User> {

                override fun onSuccess(t: User) {
                    Toast.makeText(context, "Username already exists", Toast.LENGTH_SHORT).show()
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                    try {
                        authViewmodel.addUser(
                            binding.createUsername.text.toString(),
                            binding.createPassword.text.toString(),
                            Integer.parseInt(binding.weight.text.toString()),
                            Integer.parseInt(binding.height.text.toString()),
                            Integer.parseInt(binding.age.text.toString()),
                            binding.spinner.selectedItem.toString(),
                            binding.spinner2.selectedItem.toString()
                        )
                        activity?.supportFragmentManager?.popBackStackImmediate();
                    } catch (e: Throwable) {
                        Toast.makeText(context, "Fill all the fields correctly", Toast.LENGTH_SHORT)
                            .show()
                    }


                }
            })


    }

}
