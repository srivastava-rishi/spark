package com.rsstudio.spark.db.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.rsstudio.spark.model.ProductsData

class Converters {
    @TypeConverter
    fun stringToProductDataModel(value: String): ProductsData {
        val gson = Gson()
        return gson.fromJson(value, ProductsData::class.java)
    }

    @TypeConverter
    fun productDataToString(productsData: ProductsData): String {
        val gson = Gson()
        return gson.toJson(productsData)
    }
}