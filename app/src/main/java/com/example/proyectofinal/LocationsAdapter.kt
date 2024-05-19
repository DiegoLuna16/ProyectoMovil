package com.example.proyectofinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class LocationsAdapter (private val locationList:ArrayList<Locations>)
    : RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>(){

    var onItemClick : ((Locations) -> Unit)? = null
    class LocationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewLocation : TextView = itemView.findViewById(R.id.textCardLocation)
        val textViewAddress : TextView = itemView.findViewById(R.id.textCardAddress)
        val textViewState : TextView = itemView.findViewById(R.id.textCardState)
        val textViewDistance : TextView = itemView.findViewById(R.id.textCardDistance)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_locations,parent,false)
        return LocationsViewHolder(view)
    }
    override fun getItemCount(): Int {
        return locationList.size
    }
    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        val location = locationList[position]
        holder.textViewLocation.text = location.name
        holder.textViewAddress.text = location.address
        holder.textViewState.text = location.state
        holder.textViewDistance.text = location.distance

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(location)
        }
    }
}