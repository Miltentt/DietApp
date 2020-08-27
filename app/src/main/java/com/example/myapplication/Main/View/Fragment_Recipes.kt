package com.example.myapplication.Main.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.DI.ViewModelsProviderFactory
import com.example.myapplication.Main.Adapters.Recipes_Adapter
import com.example.myapplication.Main.ViewModel.Meal_Recipe_SharedViewModel
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_cradview_meals.*
import javax.inject.Inject

class Fragment_Recipes @Inject constructor() : DaggerFragment() {
    lateinit var meal_viewmodel : Meal_Recipe_SharedViewModel
    @Inject
    lateinit var  viewmodelprovider : ViewModelsProviderFactory
    private  var recipe_adapter = Recipes_Adapter()

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
        return inflater.inflate(R.layout.fragment_cradview_meals,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(view)
        initLiveData()
    }

    fun initRecycler(view : View) {
        recipe_recycler.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = recipe_adapter
        }
    }
 fun initLiveData()
 {
     meal_viewmodel.returnRecipeLiveData().observe({lifecycle},{recipe_adapter.updateAdapter(it)})
 }


}