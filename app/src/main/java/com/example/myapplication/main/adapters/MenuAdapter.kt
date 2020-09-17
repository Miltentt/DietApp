package com.example.myapplication.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecyclerRecipeBinding
import com.example.myapplication.models.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_recipe.view.*

class MenuAdapter (private val onClick: (recipe: Recipe, image: ImageView) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Recipe, MenuAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
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
        val binding: RecyclerRecipeBinding,
        private val onClick: (recipe: Recipe, image : ImageView) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) = with(binding.root) {
            val recipename = recipe_name
            val recipephoto = recipe_photo
            recipename.text = recipe.label
            Picasso.get().load(recipe.photo).into(recipephoto)
            recipephoto.transitionName=recipe.label
            setOnClickListener { onClick(recipe,recipephoto) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Recipe>() {
            override fun areItemsTheSame(
                oldItem: Recipe,
                newItem: Recipe
            ): Boolean =
                oldItem.label == newItem.label

            override fun areContentsTheSame(
                oldItem: Recipe,
                newItem: Recipe
            ): Boolean =
                oldItem == newItem
        }
    }
}