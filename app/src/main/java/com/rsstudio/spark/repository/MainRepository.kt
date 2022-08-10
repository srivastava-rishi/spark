package com.rsstudio.spark.repository

import com.rsstudio.spark.api.ApiService
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val api: ApiService) {

    suspend fun getProductInfo() = api.getProductsData()
}