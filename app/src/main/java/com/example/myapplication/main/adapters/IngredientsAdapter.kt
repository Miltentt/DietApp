package com.example.myapplication.main.adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.R
import kotlinx.android.synthetic.main.recycler_ingredients.view.*

class IngredientsAdapter() :
    androidx.recyclerview.widget.ListAdapter<EdamamResponse.Hit.Recipe.Ingredient, IngredientsAdapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_ingredients, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        itemView: View

    ) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(ingredient: EdamamResponse.Hit.Recipe.Ingredient) = with(itemView) {
            val ingredients = itemView.ingredient
            ingredients.text=ingredient.text
            amount.visibility=View.GONE
            ingredients.gravity= Gravity.CENTER


        }

    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EdamamResponse.Hit.Recipe.Ingredient>() {
            override fun areItemsTheSame(oldItem: EdamamResponse.Hit.Recipe.Ingredient, newItem: EdamamResponse.Hit.Recipe.Ingredient): Boolean =
                oldItem.text == newItem.text

            override fun areContentsTheSame(oldItem: EdamamResponse.Hit.Recipe.Ingredient, newItem: EdamamResponse.Hit.Recipe.Ingredient): Boolean =
                oldItem == newItem
        }
    }
}