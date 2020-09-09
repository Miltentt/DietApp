package com.example.myapplication.Main.View

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.Auth.ViewModels.Auth_ViewModel
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.ViewModel.EditUser_ViewModel
import com.example.myapplication.Model.User
import com.example.myapplication.R
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_create_user.*
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.age
import kotlinx.android.synthetic.main.fragment_user.create_password
import kotlinx.android.synthetic.main.fragment_user.create_username
import kotlinx.android.synthetic.main.fragment_user.height
import kotlinx.android.synthetic.main.fragment_user.spinner
import kotlinx.android.synthetic.main.fragment_user.spinner2
import kotlinx.android.synthetic.main.fragment_user.weight
import javax.inject.Inject

class Fragment_EditUser : DaggerFragment() {
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    private lateinit var edituserViewmodel : EditUser_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        edit.setOnClickListener {view->setclickable(view); Log.i("xd","clicked")}
        edituserViewmodel = ViewModelProviders.of(this, viewmodelprovider)[EditUser_ViewModel::class.java]
        edituserViewmodel.loaduser().observe({lifecycle},{t->fillUser(t.data); confirm.setOnClickListener {updateUser(t.data)}})
        enterTransition = MaterialFadeThrough().apply { duration = 1000}
        exitTransition = MaterialFadeThrough().apply { duration = 1000 }
        super.onViewCreated(view, savedInstanceState)

    }


    private fun setclickable(view : View)
    {

        create_password.isEnabled = true
        height.isEnabled=true
        age.isEnabled = true
        weight.isEnabled = true
        confirm.visibility=View.VISIBLE
        spinner.visibility=View.VISIBLE
        spinner2.visibility=View.VISIBLE
        sex.visibility=View.GONE
        exercise.visibility=View.GONE
    }

    private fun fillUser(user : User?)
    {
        create_username.setText(user?.username)
        create_password.setText(user?.password)
        age.setText(Integer.toString(user!!.age))
        height.setText(Integer.toString(user!!.height))
        weight.setText(Integer.toString(user!!.weight))
        sex.setText(user?.sex)
        exercise.setText(edituserViewmodel.return_exercise(user?.exercise))
    }

    private fun updateUser(user: User?)
    {
        try {
            edituserViewmodel.updateUser(
                user!!.id,
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



}