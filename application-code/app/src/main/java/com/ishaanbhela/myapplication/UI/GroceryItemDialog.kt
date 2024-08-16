package com.ishaanbhela.myapplication.UI

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.ishaanbhela.myapplication.GroceryItems
import com.ishaanbhela.myapplication.R

class GroceryItemDialog(context: Context, var dialogListener: DialogListener) : AppCompatDialog(context) {
    lateinit var etItemName : EditText
    lateinit var etItemQuantity : EditText
    lateinit var etItemPrice : EditText
    lateinit var tvSave : TextView
    lateinit var tvCancel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.grocerydialog)

        etItemName = findViewById(R.id.etItemName)!!
        etItemQuantity = findViewById(R.id.etItemQuantity)!!
        etItemPrice = findViewById(R.id.etItemPrice)!!
        tvSave = findViewById(R.id.tvSave)!!
        tvCancel = findViewById(R.id.tvCancel)!!

        // Click listener on Save button
        // to save all data.
        tvSave.setOnClickListener {

            // Take all three inputs in different variables from user
            // and add it in Grocery Items database
            val name = etItemName.text.toString()
            val quantity = etItemQuantity.text.toString().toInt()
            val price = etItemPrice.text.toString().toInt()

            // Toast to display enter items in edit text
            if (name.isEmpty()) {
                Toast.makeText(context, "Please Enter Item Name", Toast.LENGTH_SHORT).show()
            }

            val item = GroceryItems(name, quantity, price)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }

        // On click listener on cancel text to close dialog box
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}