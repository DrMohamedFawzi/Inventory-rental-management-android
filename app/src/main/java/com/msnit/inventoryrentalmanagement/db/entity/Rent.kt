package com.msnit.inventoryrentalmanagement.db.entity

import androidx.room.Entity


import androidx.room.PrimaryKey

@Entity(tableName = "rents")
data class Rent(
    @PrimaryKey(autoGenerate = true)
    val rentId: Long = 0,

    val name: String,
    val username: String,
    val items: List<Item>,
    val quantity: Int
)
