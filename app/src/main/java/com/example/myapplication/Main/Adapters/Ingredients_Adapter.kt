package com.example.myapplication.Main.Adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.R
import com.example.myapplication.databinding.RecyclerIngredientsBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_ingredients.view.*
import kotlinx.android.synthetic.main.recycler_recipe.view.*

class Ingredients_Adapter() :
    androidx.recyclerview.widget.ListAdapter<Edamam_Response.Hit.Recipe.Ingredient, Ingredients_Adapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context)
        val binding = RecyclerIngredientsBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        val binding: RecyclerIngredientsBinding

    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: Edamam_Response.Hit.Recipe.Ingredient) = with(itemView) {
            val ingredients = itemView.ingredient
            ingredients.text=ingredient.text
            amount.visibility=View.GONE
            ingredients.gravity= Gravity.CENTER


        }

    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Edamam_Response.Hit.Recipe.Ingredient>() {
            override fun areItemsTheSame(oldItem: Edamam_Response.Hit.Recipe.Ingredient, newItem: Edamam_Response.Hit.Recipe.Ingredient): Boolean =
                oldItem.text == newItem.text

            override fun areContentsTheSame(oldItem: Edamam_Response.Hit.Recipe.Ingredient, newItem: Edamam_Response.Hit.Recipe.Ingredient): Boolean =
                oldItem == newItem
        }
    }
}
