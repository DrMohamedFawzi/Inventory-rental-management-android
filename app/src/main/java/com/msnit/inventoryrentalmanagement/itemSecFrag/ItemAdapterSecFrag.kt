package com.msnit.inventoryrentalmanagement.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.entity.Item

class ItemAdapterSecFrag(private val data: List<Item>, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ItemAdapterSecFrag.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        // Set click listener for the item view
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        private val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)

        fun bind(item: Item) {
            titleTextView.text = " title: ${item.name}"
            descriptionTextView.text =  "description: ${item.description}"
            priceTextView.text = "Price: ${item.rentalPrice}"
            quantityTextView.text = "Quantity: ${item.quantity}"
        }
    }
}