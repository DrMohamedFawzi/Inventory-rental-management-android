package com.msnit.inventoryrentalmanagement



import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.msnit.inventoryrentalmanagement.db.DbConnection

class CustomDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_main, null)
        builder.setView(view)

        builder.setPositiveButton("OK") { dialog, _ ->

        }
        builder.setNegativeButton("Close") { dialog, _ ->
            dialog.dismiss()
        }
        val db = DbConnection(context).db;

        return builder.create()
    }

}