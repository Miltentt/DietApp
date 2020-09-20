package com.example.myapplication.main.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFoodScheduleBinding
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.adapters.MenuAdapter
import com.example.myapplication.main.viewmodels.FavouritesViewModel
import com.example.myapplication.models.Recipe
import com.google.android.material.transition.MaterialFadeThrough
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FragmentFavourites : DaggerFragment() {

    private lateinit var binding: FragmentFoodScheduleBinding

    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var favouritesViewModel: FavouritesViewModel
    private val menuAdapter = MenuAdapter { recipe, image -> onClick(recipe, image) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_food_schedule, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        favouritesViewModel = ViewModelProviders.of(
            requireActivity(),
            viewmodelprovider
        )[FavouritesViewModel::class.java]
        binding.breakfastrecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuAdapter
        }
        loadRecipes()
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough().apply { duration = 1000 }
        exitTransition = MaterialFadeThrough().apply { duration = 1000 }
    }

    private fun onClick(recipe: Recipe, image: ImageView) {
        val bundle = Bundle()
        bundle.putParcelable("recipe", recipe)
        val fragmentRecipe = FragmentRecipe()
        fragmentRecipe.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragmentRecipe)
            .addSharedElement(image, recipe.label)
            .addToBackStack(null)
            .commit()
    }

    private fun loadRecipes()
    {

        favouritesViewModel.returnRecipeLiveData("Breakfast").observe({lifecycle},{menuAdapter.submitList(it)})

    }


}