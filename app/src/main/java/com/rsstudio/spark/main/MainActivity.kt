package com.rsstudio.spark.main


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rsstudio.spark.R
import com.rsstudio.spark.base.BaseActivity
import com.rsstudio.spark.databinding.ActivityMainBinding
import com.rsstudio.spark.model.ProductsData
import com.rsstudio.spark.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    var logTag = "@MainActivity"

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()
        initObservers()
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.white2)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }

    private fun initObservers(){

        viewModel.productData.observe(this) {

            if (it != null) {
                // submit list
                val list: MutableList<ProductsData> = mutableListOf()
//                list.addAll(it)
                Log.d(logTag, "onCreate: data$list")

            }
        }

    }


}