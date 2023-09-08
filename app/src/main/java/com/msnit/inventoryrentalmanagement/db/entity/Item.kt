package com.msnit.inventoryrentalmanagement.db.entity

import androidx.room.Entity


import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val itemId: Long = 0,

    val name: String,
    val description: String,
    val category: String,
    val rentalPrice: Double,
    val quantity: Int
)
