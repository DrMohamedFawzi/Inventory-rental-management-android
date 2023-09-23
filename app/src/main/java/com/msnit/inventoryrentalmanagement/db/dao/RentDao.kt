package com.msnit.inventoryrentalmanagement.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.msnit.inventoryrentalmanagement.db.entity.Item
import com.msnit.inventoryrentalmanagement.db.entity.Rent

@Dao
interface RentDao {
    @Insert
    suspend fun insert(rent: Rent)

    @Query("SELECT * FROM rents")
    suspend fun getAllRents(): List<Rent>

    @Query("SELECT * FROM rents WHERE rentId = :rentId")
    suspend fun getRentById(rentId: Long): Rent?

    @Query("DELETE FROM rents WHERE rentId = :rentId")
    suspend fun deleteRent(rentId: Long)

    @Query("UPDATE rents SET quantity = :newQuantity WHERE rentId = :rentId")
    suspend fun updateRentQuantity(rentId: Long, newQuantity: Int)
}