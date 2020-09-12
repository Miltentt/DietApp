package com.example.myapplication.main.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.viewmodels.Meal_Recipe_SharedViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentChooseMealBinding
import com.google.android.material.transition.MaterialFadeThrough
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FragmentMeal @Inject constructor() : DaggerFragment() {
    private lateinit var mealViewmodel: Meal_Recipe_SharedViewModel
    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var binding: FragmentChooseMealBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mealViewmodel = ViewModelProviders.of(
            requireActivity(),
            viewmodelprovider
        )[Meal_Recipe_SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_meal, container, false)
        return binding.root
    }

    fun next() {
        mealViewmodel.getRecipes(
            binding.mealtypeSpinner.selectedItem.toString(),
            binding.cuisineSpinner.selectedItem.toString(),
            binding.dietSpinner.selectedItem.toString()
        )
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, FragmentRecipes())
            .addToBackStack(null)
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchrecipes.setOnClickListener{ next() }
        enterTransition = MaterialFadeThrough().apply { duration = 1000 }
        exitTransition = MaterialFadeThrough().apply { duration = 1000 }
        super.onViewCreated(view, savedInstanceState)
    }

}