package com.rsstudio.spark.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rsstudio.spark.db.dao.SavedProductDao
import com.rsstudio.spark.db.entity.SavedProductEntity

@Database(entities = [SavedProductEntity::class], version = 1)
abstract class SavedProductDatabase:  RoomDatabase() {

    abstract fun productDao(): SavedProductDao

}