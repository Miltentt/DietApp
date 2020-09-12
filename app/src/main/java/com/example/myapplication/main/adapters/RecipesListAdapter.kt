package com.example.myapplication.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.edamamResponse.EdamamResponse
import com.example.myapplication.databinding.RecyclerRecipeBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_recipe.view.*

class RecipesListAdapter(private val onClick: (recipe: EdamamResponse.Hit.Recipe) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<EdamamResponse.Hit.Recipe, RecipesListAdapter.ViewHolder>(
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
        private val onClick: (recipe: EdamamResponse.Hit.Recipe) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: EdamamResponse.Hit.Recipe) = with(binding.root) {
            val recipename = itemView.recipe_name
            val recipephoto = itemView.recipe_photo
            recipename.text = recipe.label
            Picasso.get().load(recipe.image).into(recipephoto)
            setOnClickListener { onClick(recipe) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EdamamResponse.Hit.Recipe>() {
            override fun areItemsTheSame(
                oldItem: EdamamResponse.Hit.Recipe,
                newItem: EdamamResponse.Hit.Recipe
            ): Boolean =
                oldItem.uri == newItem.uri

            override fun areContentsTheSame(
                oldItem: EdamamResponse.Hit.Recipe,
                newItem: EdamamResponse.Hit.Recipe
            ): Boolean =
                oldItem == newItem
        }
    }
}
