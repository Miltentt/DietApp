package com.example.myapplication.Main.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_user.*

class Fragment_EditUser : DaggerFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        edit.setOnClickListener {view->setclickable(view); Log.i("xd","clicked")}
        super.onViewCreated(view, savedInstanceState)

    }


    private fun setclickable(view : View)
    {
        create_username.isClickable=true
        create_password.isClickable=true
        age.isClickable=true
        height.isClickable=true
        weight.isClickable=true
        spinner.isClickable=true
        spinner2.isClickable=true
        confirm.visibility=View.VISIBLE
    }

}