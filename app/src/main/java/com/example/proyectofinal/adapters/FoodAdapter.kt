package com.example.proyectofinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.models.Food

class FoodAdapter(private val foodList:ArrayList<Food>)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    var onItemClick : ((Food) -> Unit)? = null

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageCard)
        val textViewTitle : TextView = itemView.findViewById(R.id.textCardTitle)
        val textViewDescription : TextView = itemView.findViewById(R.id.textCardDescription)
        val textViewPrice : TextView = itemView.findViewById(R.id.textCardPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.imageView.setImageResource(food.image)
        holder.textViewTitle.text = food.name
        holder.textViewDescription.text = food.description
        holder.textViewPrice.text = food.price

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(food)
        }
    }
}