package com.example.myapplication.Main.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Main.Adapters.Ingredients_Adapter
import com.example.myapplication.Main.Adapters.Nutrients_Adapter
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.Model.Edamam_Response.Nutrient
import com.example.myapplication.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recipe.*

class Fragment_Recipe : DaggerFragment() {
    var recipe : Edamam_Response.Hit.Recipe? = null
private val ingredientsAdapter = Ingredients_Adapter()
    private val nutrientsAdapter = Nutrients_Adapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

         recipe = this.arguments?.getParcelable<Edamam_Response.Hit.Recipe>("recipe")
        title.text = recipe?.label
        recipe_url.text = "Original Recipe: " + recipe?.url
        servings.text = ("Number of Servings: " + String.format("%.0f",recipe?.yield))
        calories.text = "Calories: " + String.format("%.0f",recipe?.calories)
        recycler_ingredients.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=ingredientsAdapter
        }
        ingredientsAdapter.submitList(recipe?.ingredients)
        recycler_nutrients.apply {
            adapter=nutrientsAdapter
        layoutManager=LinearLayoutManager(context)}
        nutrientsAdapter.submitList(populatelist())
        super.onViewCreated(view, savedInstanceState)

    }



    private fun populatelist() : ArrayList<Nutrient>
    {
        val list = ArrayList<Nutrient>()
       list.add(recipe?.totalNutrients!!.cA)
        list.add(recipe?.totalNutrients!!.cHOCDF)
        list.add(recipe?.totalNutrients!!.cHOLE)
        list.add(recipe?.totalNutrients!!.eNERCKCAL)
        list.add(recipe?.totalNutrients!!.fAMS)
        list.add(recipe?.totalNutrients!!.fAPU)
        list.add(recipe?.totalNutrients!!.fASAT)
        list.add(recipe?.totalNutrients!!.fAT)
        list.add(recipe?.totalNutrients!!.fATRN)
        list.add(recipe?.totalNutrients!!.fE)
        list.add(recipe?.totalNutrients!!.fIBTG)
        list.add(recipe?.totalNutrients!!.fOLAC)
        list.add(recipe?.totalNutrients!!.fOLDFE)
        list.add(recipe?.totalNutrients!!.fOLFD)
        list.add(recipe?.totalNutrients!!.k)
        list.add(recipe?.totalNutrients!!.mG)
        list.add(recipe?.totalNutrients!!.nA)
        list.add(recipe?.totalNutrients!!.nIA)
        list.add(recipe?.totalNutrients!!.p)
        list.add(recipe?.totalNutrients!!.pROCNT)
        list.add(recipe?.totalNutrients!!.rIBF)
        list.add(recipe?.totalNutrients!!.sUGAR)
        list.add(recipe?.totalNutrients!!.tHIA)
        list.add(recipe?.totalNutrients!!.tOCPHA)
        list.add(recipe?.totalNutrients!!.vITARAE)
        list.add(recipe?.totalNutrients!!.vITB12)
        list.add(recipe?.totalNutrients!!.vITB6A)
        list.add(recipe?.totalNutrients!!.vITC)
        list.add(recipe?.totalNutrients!!.vITD)
        list.add(recipe?.totalNutrients!!.vITK1)
        list.add(recipe?.totalNutrients!!.wATER)
        list.add(recipe?.totalNutrients!!.zN)
        return list
    }




}