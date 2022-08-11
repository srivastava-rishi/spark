package com.rsstudio.spark.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savedProductData")
data class Info(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val brand: String,
    val saved: Boolean,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)
