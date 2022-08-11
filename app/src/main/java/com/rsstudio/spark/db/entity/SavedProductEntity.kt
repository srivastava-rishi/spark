package com.rsstudio.spark.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savedProductData")
data class SavedProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val saved: Boolean,
    val category: String,
    val description: String,
    val images: String,
    val rating: Double,
    val title: String
)