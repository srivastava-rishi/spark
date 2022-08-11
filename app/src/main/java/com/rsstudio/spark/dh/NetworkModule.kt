package com.rsstudio.spark.dh

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.rsstudio.spark.api.ApiService
import com.rsstudio.spark.constant.Constant
import com.rsstudio.spark.db.database.SavedProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitService(): ApiService =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideSavedNewsDb(app: Application): SavedProductDatabase =
        Room.databaseBuilder(app, SavedProductDatabase::class.java,"savedProductData")
            .build()
}