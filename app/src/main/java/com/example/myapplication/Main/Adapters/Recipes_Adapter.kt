package com.example.myapplication.Main.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Edamam_Response.Edamam_Response
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_recipe.view.*

class Recipes_Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

 private var items : ArrayList<Edamam_Response.Hit.Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_recipe,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      when(holder)
      {
          is Viewholder -> {holder.bind(items.get(position))}
      }
    }

    class Viewholder (itemView : View
    ) : RecyclerView.ViewHolder(itemView) {
        val recipename = itemView.recipe_name
        val recipephoto = itemView.recipe_photo

        fun bind(recipe: Edamam_Response.Hit.Recipe) {
            recipename.setText(recipe.label)
            Picasso.get().load(recipe.image).into(recipephoto)
        }
    }
    fun updateAdapter(recipes : ArrayList<Edamam_Response.Hit.Recipe>)
    {
        items = recipes
        notifyDataSetChanged()
    }
}