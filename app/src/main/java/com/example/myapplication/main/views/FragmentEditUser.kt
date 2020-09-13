package com.example.myapplication.main.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.viewmodels.EditUserViewModel
import com.example.myapplication.models.User
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserBinding
import com.google.android.material.transition.MaterialFadeThrough
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FragmentEditUser : DaggerFragment() {
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var edituserViewmodel: EditUserViewModel
    private lateinit var binding: FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.edit.setOnClickListener { setclickable(it); Log.i("xd", "clicked") }
        edituserViewmodel =
            ViewModelProviders.of(this, viewmodelprovider)[EditUserViewModel::class.java]
        edituserViewmodel.loaduser().observe({ lifecycle },
            { t -> fillUser(t.data); binding.confirm.setOnClickListener { updateUser(t.data) } })
        enterTransition = MaterialFadeThrough().apply { duration = 1000 }
        exitTransition = MaterialFadeThrough().apply { duration = 1000 }
        super.onViewCreated(view, savedInstanceState)

    }


    private fun setclickable(view: View) {

        binding.createPassword.isEnabled = true
        binding.height.isEnabled = true
        binding.age.isEnabled = true
        binding.weight.isEnabled = true
        binding.confirm.visibility = View.VISIBLE
        binding.spinner.visibility = View.VISIBLE
        binding.spinner2.visibility = View.VISIBLE
        binding.sex.visibility = View.GONE
        binding.exercise.visibility = View.GONE
    }

    private fun fillUser(user: User?) {
        binding.createUsername.setText(user?.username)
        binding.createPassword.setText(user?.password)
        binding.age.setText(String.format("%d",user!!.age))
        binding.height.setText(String.format("%d",user.height))
        binding.weight.setText(String.format("%d",user.weight))
        binding.sex.setText(user.sex)
        binding.exercise.setText(edituserViewmodel.returnExercise(user.exercise))
    }

    private fun updateUser(user: User?) {
        try {
            edituserViewmodel.updateUser(
                user!!.id,
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
            Toast.makeText(context, "Fill all the fields correctly", Toast.LENGTH_SHORT).show()
        }


    }


}