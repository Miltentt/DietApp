package com.example.myapplication.Main.Adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.Model.Edamam_Response.Nutrient
import com.example.myapplication.R
import com.example.myapplication.databinding.RecyclerIngredientsBinding
import kotlinx.android.synthetic.main.recycler_ingredients.view.*

class Nutrients_Adapter() :
    androidx.recyclerview.widget.ListAdapter<Nutrient, Nutrients_Adapter.ViewHolder>(DIFF_CALLBACK) {
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
        val binding : RecyclerIngredientsBinding

    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(nutrient: Nutrient) = with(itemView) {
            val ingredients = itemView.ingredient
            val amount = itemView.amount
            ingredients.text=nutrient.label + " "
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