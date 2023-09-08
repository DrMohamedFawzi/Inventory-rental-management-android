package com.msnit.inventoryrentalmanagement.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.msnit.inventoryrentalmanagement.db.dao.ItemDao
import com.msnit.inventoryrentalmanagement.db.dao.UtilDao
import com.msnit.inventoryrentalmanagement.db.entity.Item

import com.msnit.inventoryrentalmanagement.db.entity.UtilEntity

@Database(entities = [Item::class, UtilEntity::class], version = 1)
abstract class RentalDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun utilDao(): UtilDao


    companion object {
        private var instance: RentalDatabase? = null

        fun getInstance(context: Context): RentalDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    RentalDatabase::class.java,
                    "rental_db"
                ).build()
            }
            return instance as RentalDatabase
        }
    }
}
