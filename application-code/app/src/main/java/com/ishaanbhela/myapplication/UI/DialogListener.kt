package com.ishaanbhela.myapplication.UI
import com.ishaanbhela.myapplication.GroceryItems

interface DialogListener {

    // Create a function to add items
    // in GroceryItems on clicking
    fun onAddButtonClicked(item: GroceryItems)
}