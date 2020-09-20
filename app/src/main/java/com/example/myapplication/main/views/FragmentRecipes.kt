package com.example.myapplication.main.views

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.adapters.RecipesListAdapter
import com.example.myapplication.main.viewmodels.Meal_Recipe_SharedViewModel
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCradviewMealsBinding
import com.example.myapplication.models.Recipe
import com.example.myapplication.models.edamamResponse.Nutrient
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FragmentRecipes @Inject constructor() : DaggerFragment() {
    lateinit var meal_viewmodel: Meal_Recipe_SharedViewModel

    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private var recipe_adapter = RecipesListAdapter { recipe, image -> onClick(recipe, image) }
    private lateinit var binding: FragmentCradviewMealsBinding
    private var mealtype: String? = null
    private val list = ArrayList<Nutrient>()
    private val ingredients = ArrayList<String>()
    private val nutrients = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mealtype = arguments?.getString("mealType")
        meal_viewmodel =
            ViewModelProviders.of(
                requireActivity(),
                viewmodelprovider
            )[Meal_Recipe_SharedViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cradview_meals, container, false)
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

    private fun initLiveData() {
        meal_viewmodel.returnRecipeLiveData().observe({ lifecycle }, {
            recipe_adapter.submitList(it)
            binding.recipeRecycler.visibility = View.VISIBLE
            binding.progress.visibility = View.GONE
        })
    }

    private fun onClick(recipe: EdamamResponse.Hit.Recipe, image: ImageView) {
        val bundle = Bundle()
        populateArray(recipe)
        bundle.putParcelable("recipe", createRecipe(recipe,mealtype!!))
        val fragmentRecipe = FragmentRecipe()
        fragmentRecipe.arguments = bundle
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragmentRecipe)
            .addSharedElement(image, recipe.label)
            .addToBackStack(null)
            .commit()

    }


    private fun populateArray(recipe: EdamamResponse.Hit.Recipe) {
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
    }

    private fun createRecipe(recipe: EdamamResponse.Hit.Recipe,mealtype : String) : Recipe {
        for (x in recipe.ingredients.listIterator()) {
            ingredients.add(x.text)
        }
        for (x in list.iterator()) {
            nutrients.add(x.label + "  " + x.quantity.toString() + x.unit)
        }
        return  Recipe(
            ingredients = ingredients,
            nutrients = nutrients,
            url = recipe.url,
            calories = recipe.calories.toString(),
            servings = recipe.yield.toString(),
            mealType = mealtype,
            label = recipe.label,
            photo = recipe.image,
            favourite = false
        )
    }
}