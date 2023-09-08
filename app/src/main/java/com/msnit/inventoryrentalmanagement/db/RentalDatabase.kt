package com.msnit.inventoryrentalmanagement.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.msnit.inventoryrentalmanagement.db.dao.ItemDao
import com.msnit.inventoryrentalmanagement.db.dao.UtilDao
import com.msnit.inventoryrentalmanagement.db.entity.Item

import com.msnit.inventoryrentalmanagement.db.entity.UtilEntity

@Database(entities = [Item::class, UtilEntity::class], version = 1)
abstract class RentalDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun utilDao(): UtilDao
}
