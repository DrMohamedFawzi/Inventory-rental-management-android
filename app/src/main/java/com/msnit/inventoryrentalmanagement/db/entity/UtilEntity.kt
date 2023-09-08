package com.msnit.inventoryrentalmanagement.db.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "util")
data class UtilEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,
    val value: String
)
