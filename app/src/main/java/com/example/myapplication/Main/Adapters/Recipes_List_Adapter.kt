package com.example.myapplication.Main.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.R
import com.example.myapplication.databinding.RecyclerRecipeBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_recipe.view.*

class Recipes_List_Adapter(private val onClick: (recipe: Edamam_Response.Hit.Recipe) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Edamam_Response.Hit.Recipe, Recipes_List_Adapter.ViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context)
        val binding = RecyclerRecipeBinding.inflate(inflater)

        return ViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(
        val binding : RecyclerRecipeBinding,
        private val onClick: (recipe: Edamam_Response.Hit.Recipe) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Edamam_Response.Hit.Recipe) = with(binding.root) {
            val recipename = itemView.recipe_name
            val recipephoto = itemView.recipe_photo
            recipename.text=recipe.label
            Picasso.get().load(recipe.image).into(recipephoto)
            setOnClickListener { onClick(recipe) }

        }

    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Edamam_Response.Hit.Recipe>() {
            override fun areItemsTheSame(oldItem: Edamam_Response.Hit.Recipe, newItem: Edamam_Response.Hit.Recipe): Boolean =
                oldItem.uri == newItem.uri

            override fun areContentsTheSame(oldItem: Edamam_Response.Hit.Recipe, newItem: Edamam_Response.Hit.Recipe): Boolean =
                oldItem == newItem
        }
    }
}
