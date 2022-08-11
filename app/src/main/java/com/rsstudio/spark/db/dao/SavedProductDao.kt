package com.rsstudio.spark.db.dao

import androidx.room.*
import com.rsstudio.spark.db.entity.SavedProductEntity
import com.rsstudio.spark.model.Info
import com.rsstudio.spark.model.ProductsData
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductData(savedProductData: ProductsData)

    @Delete
    fun deleteSavedProductData(deleteProductEntity: Info)

    @Update
    suspend fun updateSavedProductData(savedProductEntity: SavedProductEntity)

    @Query("SELECT * FROM savedProductData")
    fun getProductData(): Flow<ProductsData>

    @Query("SELECT * FROM savedProductData")
    fun getBookMarkedProductData() : ArrayList<Info>

}