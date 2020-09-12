package com.example.myapplication.Main.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.Adapters.Recipes_List_Adapter
import com.example.myapplication.Main.ViewModel.Meal_Recipe_SharedViewModel
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCradviewMealsBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class Fragment_Recipes @Inject constructor() : DaggerFragment() {
    lateinit var meal_viewmodel : Meal_Recipe_SharedViewModel
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    private  var recipe_adapter = Recipes_List_Adapter{recipe ->onClick(recipe)}
    private lateinit var binding : FragmentCradviewMealsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        meal_viewmodel =
            ViewModelProviders.of(requireActivity(), viewmodelprovider)[Meal_Recipe_SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cradview_meals,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initLiveData()
    }

    private fun initRecycler() {
        binding.recipeRecycler.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = recipe_adapter
        }
    }
 private fun initLiveData()
 {
     meal_viewmodel.returnRecipeLiveData().observe({lifecycle},{recipe_adapter.submitList(it)})
 }

    private fun onClick(recipe : Edamam_Response.Hit.Recipe)
    {
        val bundle = Bundle()
        bundle.putParcelable("recipe",recipe)
        val fragmentRecipe = Fragment_Recipe()
        fragmentRecipe.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment,fragmentRecipe)
            .addToBackStack(null)
            .commit()

    }

}