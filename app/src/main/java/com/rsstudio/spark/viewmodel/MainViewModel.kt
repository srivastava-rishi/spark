package com.rsstudio.spark.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsstudio.spark.db.database.SavedProductDatabase
import com.rsstudio.spark.model.Info
import com.rsstudio.spark.model.ProductsData
import com.rsstudio.spark.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val repository: MainRepository,
    ) : ViewModel() {

    var logTag = "@MainViewModel"

    // the pattern that i usually follow
    private val _productData: MutableLiveData<ProductsData> = MutableLiveData()
    val productData: LiveData<ProductsData> get() = _productData


    init {
        getProductInfo()
    }

    private fun getProductInfo() {

        viewModelScope.launch {

            repository.getProductInfo().let {

                if (it.isSuccessful) {
                    _productData.postValue(it.body())
                } else {
                    Log.d(logTag, "error: ${it.errorBody()} ")
                }

            }

        }
    }



}