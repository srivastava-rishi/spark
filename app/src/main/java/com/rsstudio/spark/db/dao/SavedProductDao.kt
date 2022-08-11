package com.rsstudio.spark.db.dao

import androidx.room.*
import com.rsstudio.spark.db.entity.SavedProductEntity

@Dao
interface SavedProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductData(savedProductEntity: SavedProductEntity)

    @Delete
    fun deleteSavedProductData(savedProductEntity: SavedProductEntity)

    @Query("SELECT * FROM savedProductData")
    fun getAllSavedProductData() : List<SavedProductEntity>


}