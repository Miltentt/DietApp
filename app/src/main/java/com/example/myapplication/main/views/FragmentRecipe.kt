package com.example.myapplication.main.views

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRecipeBinding
import com.example.myapplication.di.ViewModelsProviderFactory
import com.example.myapplication.main.adapters.IngredientsAdapter
import com.example.myapplication.main.adapters.NutrientsAdapter
import com.example.myapplication.main.viewmodels.RecipeViewModel
import com.example.myapplication.models.Recipe
import com.squareup.picasso.Picasso
import com.varunest.sparkbutton.SparkEventListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class FragmentRecipe : DaggerFragment() {
    private val ingredientsAdapter = IngredientsAdapter()
    private val nutrientsAdapter = NutrientsAdapter()
    private lateinit var binding: FragmentRecipeBinding
    private var recipe: Recipe? = null

    @Inject
    lateinit var viewmodelprovider: ViewModelsProviderFactory
    private lateinit var recipeviewmodel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recipe = requireArguments().getParcelable("recipe")
        recipeviewmodel = ViewModelProviders.of(
            requireActivity(),
            viewmodelprovider
        )[RecipeViewModel::class.java]

        binding.title.text = recipe?.label
        binding.recipeUrl.movementMethod = LinkMovementMethod.getInstance()
        val url = "<a href='" + recipe?.url + "'>" + "Original Recipe" + "</a>"
        binding.recipeUrl.text = HtmlCompat.fromHtml(url, HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.servings.text = ("Number of Servings: " + recipe?.servings)
        binding.calories.text = (getString(R.string.Calories) + recipe?.calories)
        binding.recyclerIngredients.visibility = View.GONE
        binding.recyclerNutrients.visibility = View.GONE
        binding.recyclerIngredients.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ingredientsAdapter
        }
        ingredientsAdapter.submitList(recipe?.ingredients)
        binding.recyclerNutrients.apply {
            adapter = nutrientsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        nutrientsAdapter.submitList(recipe?.nutrients)
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
        Picasso.get().load(recipe?.photo).into(binding.image)

        binding.addrecipebutton.setOnClickListener { addRecipe() }
        super.onViewCreated(view, savedInstanceState)
        binding.favouritesButton.setEventListener(object : SparkEventListener {
            override fun onEvent(button: ImageView?, buttonState: Boolean) {
                if (buttonState) {
                    addFavourite()
                } else {
                    recipeviewmodel.deleteRecipe(recipe!!.label, recipe!!.favourite)

                }
            }

            override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {
            }

            override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {
            }
        })
    }

    private fun showRecycler(button: Button, recycler: RecyclerView) {
        if (recycler.visibility == View.GONE) {
            button.text = getString(R.string.Hide)
            recycler.visibility = View.VISIBLE
        } else {
            button.text = getString(R.string.Show)
            recycler.visibility = View.GONE
        }
    }


    private fun addRecipe() {
        recipe?.favourite = false
        recipeviewmodel.insertRecipe(recipe!!)
        binding.addrecipebutton.isClickable = false
    }

    private fun addFavourite() {
        recipe?.favourite = true
        recipeviewmodel.insertRecipe(recipe!!)
    }


}