package com.msnit.inventoryrentalmanagement.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.msnit.inventoryrentalmanagement.db.entity.UtilEntity

@Dao
interface UtilDao {
    @Insert
    suspend fun insert(utilEntity: UtilEntity)

    @Query("SELECT * FROM util WHERE name = :name")
    suspend fun getValueByKey(name: String): UtilEntity?

    @Update
    suspend fun update(utilEntity: UtilEntity)

    @Query("DELETE FROM util WHERE name = :name")
    suspend fun deleteByKey(name: String)
    @Query("SELECT EXISTS(SELECT 1 FROM util LIMIT 1)")
    fun hasData(): Boolean}
