package com.example.myapplication.main.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.main.adapters.IngredientsAdapter
import com.example.myapplication.main.adapters.NutrientsAdapter
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.models.edamamResponse.Nutrient
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRecipeBinding
import dagger.android.support.DaggerFragment


class FragmentRecipe : DaggerFragment() {
    private val ingredientsAdapter = IngredientsAdapter()
    private val nutrientsAdapter = NutrientsAdapter()
    private lateinit var binding: FragmentRecipeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipe = requireArguments().getParcelable<EdamamResponse.Hit.Recipe>("recipe")
        binding.title.text = recipe?.label
        binding.recipeUrl.text = "Original Recipe: " + recipe?.url
        binding.servings.text = ("Number of Servings: " + String.format("%.0f", recipe?.yield))
        binding.calories.text = "Calories: " + String.format("%.0f", recipe?.calories)
        binding.recyclerIngredients.visibility = View.GONE
        binding.recyclerNutrients.visibility = View.GONE
        binding.recyclerIngredients.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ingredientsAdapter
        }
        ingredientsAdapter.submitList(recipe?.ingredients)
        binding.recyclerNutrients.apply {
            adapter = nutrientsAdapter
            layoutManager = LinearLayoutManager(context)
        }
        nutrientsAdapter.submitList(populatelist(recipe!!))
        binding.ingredientsButton.setOnClickListener {
            showRecycler(
                binding.ingredientsButton,
                binding.recyclerIngredients
            )
        }
        binding.nutrientsButon.setOnClickListener {
            showRecycler(
                binding.nutrientsButon,
                binding.recyclerNutrients
            )
        }
        super.onViewCreated(view, savedInstanceState)

    }

    fun showRecycler(button: Button, recycler: RecyclerView) {
        if (recycler.visibility == View.GONE) {
            button.text = "Hide"
            recycler.visibility = View.VISIBLE
        } else {
            button.text = "Show"
            recycler.visibility = View.GONE
        }
    }


    private fun populatelist(recipe: EdamamResponse.Hit.Recipe): ArrayList<Nutrient> {
        val list = ArrayList<Nutrient>()
        list.add(
            Nutrient(
                recipe.totalNutrients.cA.label,
                recipe.totalNutrients.cA.quantity,
                recipe.totalNutrients.cA.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.cHOCDF.label,
                recipe.totalNutrients.cHOCDF.quantity,
                recipe.totalNutrients.cHOCDF.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.cHOLE.label,
                recipe.totalNutrients.cHOLE.quantity,
                recipe.totalNutrients.cHOLE.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.eNERCKCAL.label,
                recipe.totalNutrients.eNERCKCAL.quantity,
                recipe.totalNutrients.eNERCKCAL.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fAMS.label,
                recipe.totalNutrients.fAMS.quantity,
                recipe.totalNutrients.fAMS.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fAPU.label,
                recipe.totalNutrients.fAPU.quantity,
                recipe.totalNutrients.fAPU.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fASAT.label,
                recipe.totalNutrients.fASAT.quantity,
                recipe.totalNutrients.fASAT.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fAT.label,
                recipe.totalNutrients.fAT.quantity,
                recipe.totalNutrients.fAT.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fATRN.label,
                recipe.totalNutrients.fATRN.quantity,
                recipe.totalNutrients.fATRN.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fE.label,
                recipe.totalNutrients.fE.quantity,
                recipe.totalNutrients.fE.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fIBTG.label,
                recipe.totalNutrients.fIBTG.quantity,
                recipe.totalNutrients.fIBTG.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fOLAC.label,
                recipe.totalNutrients.fOLAC.quantity,
                recipe.totalNutrients.fOLAC.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fOLDFE.label,
                recipe.totalNutrients.fOLDFE.quantity,
                recipe.totalNutrients.fOLDFE.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.fOLFD.label,
                recipe.totalNutrients.fOLFD.quantity,
                recipe.totalNutrients.fOLFD.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.k.label,
                recipe.totalNutrients.k.quantity,
                recipe.totalNutrients.k.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.mG.label,
                recipe.totalNutrients.mG.quantity,
                recipe.totalNutrients.mG.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.nA.label,
                recipe.totalNutrients.nA.quantity,
                recipe.totalNutrients.nA.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.nIA.label,
                recipe.totalNutrients.nIA.quantity,
                recipe.totalNutrients.nIA.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.p.label,
                recipe.totalNutrients.p.quantity,
                recipe.totalNutrients.p.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.pROCNT.label,
                recipe.totalNutrients.pROCNT.quantity,
                recipe.totalNutrients.pROCNT.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.rIBF.label,
                recipe.totalNutrients.rIBF.quantity,
                recipe.totalNutrients.rIBF.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.sUGAR.label,
                recipe.totalNutrients.sUGAR.quantity,
                recipe.totalNutrients.sUGAR.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.tHIA.label,
                recipe.totalNutrients.tHIA.quantity,
                recipe.totalNutrients.tHIA.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.tOCPHA.label,
                recipe.totalNutrients.tOCPHA.quantity,
                recipe.totalNutrients.tOCPHA.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITARAE.label,
                recipe.totalNutrients.vITARAE.quantity,
                recipe.totalNutrients.vITARAE.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITB12.label,
                recipe.totalNutrients.vITB12.quantity,
                recipe.totalNutrients.vITB12.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITB6A.label,
                recipe.totalNutrients.vITB6A.quantity,
                recipe.totalNutrients.vITB6A.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITC.label,
                recipe.totalNutrients.vITC.quantity,
                recipe.totalNutrients.vITC.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITD.label,
                recipe.totalNutrients.vITD.quantity,
                recipe.totalNutrients.vITD.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.vITK1.label,
                recipe.totalNutrients.vITK1.quantity,
                recipe.totalNutrients.vITK1.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.wATER.label,
                recipe.totalNutrients.wATER.quantity,
                recipe.totalNutrients.wATER.unit
            )
        )
        list.add(
            Nutrient(
                recipe.totalNutrients.zN.label,
                recipe.totalNutrients.zN.quantity,
                recipe.totalNutrients.zN.unit
            )
        )
        return list
    }


}