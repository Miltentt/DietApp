package com.example.myapplication.Main.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.ViewModel.Meal_Recipe_SharedViewModel

import com.example.myapplication.R
import com.google.android.material.transition.MaterialFadeThrough
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.fragment_choose_meal.*
import javax.inject.Inject

class Fragment_Meal @Inject constructor() : DaggerFragment() {
    lateinit var meal_viewmodel : Meal_Recipe_SharedViewModel
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       meal_viewmodel  = ViewModelProviders.of(requireActivity(), viewmodelprovider)[Meal_Recipe_SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_choose_meal,container,false)
    }
fun next()
{
   meal_viewmodel.getRecipes(mealtype_spinner.selectedItem.toString(),cuisine_spinner.selectedItem.toString(),diet_spinner.selectedItem.toString())
    parentFragmentManager.beginTransaction()
        .replace(R.id.nav_host_fragment,Fragment_Recipes())
        .addToBackStack(null)
        .commit()
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchrecipes.setOnClickListener({v->next()})
        enterTransition = MaterialFadeThrough().apply { duration = 1000}
        exitTransition = MaterialFadeThrough().apply { duration = 1000 }
        super.onViewCreated(view, savedInstanceState)
    }


}