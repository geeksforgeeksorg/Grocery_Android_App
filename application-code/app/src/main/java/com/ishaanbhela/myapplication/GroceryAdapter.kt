package com.ishaanbhela.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ishaanbhela.myapplication.UI.GroceryViewModel

class GroceryAdapter(var list: List<GroceryItems>, private val viewModel: GroceryViewModel) :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.groceryadapter, parent, false)
        return GroceryViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val currentPosition = list[position]
        holder.txtItemName.text = currentPosition.itemName
        holder.txtItemPrice.text = "${currentPosition.itemPrice}"
        holder.txtItemQuantity.text = "${currentPosition.itemQuantity}"

        holder.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }

        // Show total cost and title only for the last item
        if (position == list.size - 1) {
            val totalCost = list.sumBy { it.itemPrice }
            holder.txtItemTotalCost.visibility = View.VISIBLE
            holder.txtTotalCostTitle.visibility = View.VISIBLE
            holder.txtItemTotalCost.text = "$totalCost"
        } else {
            // Hide the total cost and title for non-last items
            holder.txtItemTotalCost.visibility = View.GONE
            holder.txtTotalCostTitle.visibility = View.GONE
        }
    }

    // Inner class for ViewHolder with findViewById
    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtItemName: TextView = itemView.findViewById(R.id.txtItemName)
        val txtItemPrice: TextView = itemView.findViewById(R.id.txtItemPrice)
        val txtItemQuantity: TextView = itemView.findViewById(R.id.txtItemQuantity)
        val txtItemTotalCost: TextView = itemView.findViewById(R.id.txtItemTotalCost)
        val txtTotalCostTitle: TextView = itemView.findViewById(R.id.txtTotalCostTitle)
        val ibDelete: ImageButton = itemView.findViewById(R.id.ibDelete)
    }
}