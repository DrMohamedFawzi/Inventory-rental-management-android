package com.msnit.inventoryrentalmanagement.items

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.msnit.inventoryrentalmanagement.R
import com.msnit.inventoryrentalmanagement.db.DbConnection
import com.msnit.inventoryrentalmanagement.db.RentalDatabase
import com.msnit.inventoryrentalmanagement.db.entity.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AddItemDialog(private val addItemListener: (Item) -> Unit) : DialogFragment(),
    CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_item, null)

        val editTextName = view.findViewById<EditText>(R.id.editTextName)
        val editTextDescription = view.findViewById<EditText>(R.id.editTextDescription)
        val editTextCategory = view.findViewById<EditText>(R.id.editTextCategory)
        val editTextPrice = view.findViewById<EditText>(R.id.editTextPrice)
        val editTextQuantity = view.findViewById<EditText>(R.id.editTextQuantity)

        builder.setView(view)

        builder.setPositiveButton("Add") { dialog, _ ->
            val name = editTextName.text.toString()
            val description = editTextDescription.text.toString()
            val category = editTextCategory.text.toString()
            val price = editTextPrice.text.toString().toDoubleOrNull() ?: 0.0
            val quantity = editTextQuantity.text.toString().toIntOrNull() ?: 0

            val newItem = Item(
                name = name,
                description = description,
                category = category,
                rentalPrice = price,
                quantity = quantity
            )

            addItemListener(newItem)




            // إدراج العنصر في قاعدة البيانات باستخدام ItemDao
            launch {
                val itemDao = RentalDatabase.getInstance(requireContext()).itemDao()
                itemDao.insert(newItem)
            }

            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }

        return builder.create()
    }
}