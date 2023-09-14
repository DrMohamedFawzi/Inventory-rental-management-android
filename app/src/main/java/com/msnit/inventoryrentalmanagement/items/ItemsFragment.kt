package com.msnit.inventoryrentalmanagement.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.entity.Item

class ItemsFragment : Fragment(), ItemAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val items = mutableListOf<Item>() // List to store items

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_items, container, false)

        adapter = ItemAdapter(items, this)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        var sampleItem = Item(
            name = "بطاقة 1",
            description = "Description 1",
            category = "Category 1",
            rentalPrice = 10.0,
            quantity = 5
        )
        addItem(sampleItem)


         sampleItem = Item(
            name = "بطاقة2",
            description = "Description 1",
            category = "Category 1",
            rentalPrice = 10.0,
            quantity = 5
        )
        addItem(sampleItem)


         sampleItem = Item(
            name = "بطاقة 3",
            description = "Description 1",
            category = "Category 1",
            rentalPrice = 10.0,
            quantity = 5
        )
        addItem(sampleItem)


         sampleItem = Item(
            name = "بطاق111111ة 1",
            description = "Description 1",
            category = "Category 1",
            rentalPrice = 10.0,
            quantity = 5
        )
        addItem(sampleItem)


        return view
    }

    fun addItem(item: Item) {
        items.add(item)
        adapter.notifyItemInserted(items.size - 1)
    }

     fun removeItem(position: Int) {
        items.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
    override fun onItemClick(item: Item) {
        Toast.makeText(requireContext(), "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()
    }

}
