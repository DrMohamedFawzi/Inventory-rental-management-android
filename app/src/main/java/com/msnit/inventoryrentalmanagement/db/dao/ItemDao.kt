package com.msnit.inventoryrentalmanagement.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.msnit.inventoryrentalmanagement.db.entity.Item

@Dao
interface ItemDao {
    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<Item>

    @Query("SELECT * FROM items WHERE itemId = :itemId")
    suspend fun getItemById(itemId: Long): Item?

    @Query("DELETE FROM items WHERE itemId = :itemId")
    suspend fun deleteItem(itemId: Long)

    @Query("UPDATE items SET quantity = :newQuantity WHERE itemId = :itemId")
    suspend fun updateQuantity(itemId: Long, newQuantity: Int)
}
