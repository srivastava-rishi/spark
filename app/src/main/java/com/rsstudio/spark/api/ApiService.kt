package com.rsstudio.spark.api

import com.bumptech.glide.load.engine.Resource
import com.rsstudio.spark.model.ProductsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v2/Products")
    suspend fun getProductsData(): Response<ProductsData>
}