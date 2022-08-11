package com.rsstudio.spark.db.dao

import androidx.room.*
import com.rsstudio.spark.db.entity.SavedProductEntity
import com.rsstudio.spark.model.ProductsData
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductData(savedProductEntity: SavedProductEntity)

    @Delete
    fun deleteSavedProductData(savedProductEntity: SavedProductEntity)

    @Update
    suspend fun updateSavedProductData(savedProductEntity: SavedProductEntity)

//    @Query("SELECT * FROM savedProductData")
//    fun getAllSavedProductData(): Flow<ProductsData>

    @Query("SELECT * FROM savedProductData WHERE saved = :saved")
    fun getSavedProductData(saved: Boolean = true) : List<SavedProductEntity>


}