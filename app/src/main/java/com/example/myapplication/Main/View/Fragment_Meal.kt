package com.example.myapplication.Main.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.ViewModel.Main_ViewModel
import com.example.myapplication.Main.ViewModel.Meal_ViewModel
import com.example.myapplication.Model.Edamam_Response
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class Fragment_Meal @Inject constructor() : DaggerFragment() {
    lateinit var meal_viewmodel : Meal_ViewModel
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       meal_viewmodel  = ViewModelProviders.of(this, viewmodelprovider)[Meal_ViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_choose_meal,container,false)
    }




}