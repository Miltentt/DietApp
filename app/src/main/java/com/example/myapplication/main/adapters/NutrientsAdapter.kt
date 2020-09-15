package com.example.myapplication.main.adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.edamamResponse.Nutrient
import com.example.myapplication.R
import kotlinx.android.synthetic.main.recycler_ingredients.view.*

class NutrientsAdapter() :
    androidx.recyclerview.widget.ListAdapter<Nutrient, NutrientsAdapter.ViewHolder>(DIFF_CALLBACK) {
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
        fun bind(nutrient: Nutrient) = with(itemView) {
            val ingredients = itemView.ingredient
            val amount = itemView.amount
            ingredients.text=nutrient.label
            amount.text=nutrient.quantity.toString() + " " + nutrient.unit
        }

    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Nutrient>() {
            override fun areItemsTheSame(oldItem: Nutrient, newItem: Nutrient): Boolean =
                oldItem.label == newItem.label

            override fun areContentsTheSame(oldItem: Nutrient, newItem: Nutrient): Boolean =
                oldItem == newItem
        }
    }
}