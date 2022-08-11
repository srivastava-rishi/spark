package com.rsstudio.spark.repository

import androidx.room.withTransaction
import com.rsstudio.spark.api.ApiService
import com.rsstudio.spark.db.database.SavedProductDatabase
import com.rsstudio.spark.model.ProductsData
import com.rsstudio.spark.networkbound.Resource
import com.rsstudio.spark.networkbound.networkBoundResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val api: ApiService,
    ) {

    suspend fun getProductInfo() : Response<ProductsData> {

       return  api.getProductsData()
    }

//    private val savedProductDao = db.productDao()

//    fun getProductData(
//        age: Int,
//        forceRefresh: Boolean,
//        onFetchSuccess: () -> Unit,
//        onFetchFailed: (Throwable) -> Unit
//    ) : Flow<Resource<ProductsData>> = networkBoundResource(
//
//        query = {
//            savedProductDao.getAllSavedProductData()
//        },
//
//        fetch = {
////                api.getProductsData()
//
//        },
//
//        saveFetchResult = {
////            when(it){
////                is Resource.Success<*> -> {
////                    db.withTransaction {
//////                        homeDao.deleteHomeData()
//////                        homeDao.insertHomeData(it.value)
////                    }
////                }
////                is Resource.Failure ->{
////
////                }
////                else ->{
////
////                }
////            }
//        },
//        shouldFetch = {
//            if(forceRefresh){
//                true
//            }else{
//                true
//            }
//        },
//        onFetchSuccess = onFetchSuccess,
//        onFetchFailed = {
//            onFetchFailed(it)
//        }
//    )

}