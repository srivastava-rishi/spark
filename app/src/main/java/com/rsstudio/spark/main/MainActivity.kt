package com.rsstudio.spark.main


import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsstudio.spark.R
import com.rsstudio.spark.adapter.MainAdapter
import com.rsstudio.spark.base.BaseActivity
import com.rsstudio.spark.databinding.ActivityMainBinding
import com.rsstudio.spark.model.ProductsData
import com.rsstudio.spark.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    var logTag = "@MainActivity"

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initRecyclerView()
        initObservers()
    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.layoutManager = llm
        mainAdapter = MainAdapter(this)
        binding.rvProduct.adapter = mainAdapter
    }

    private fun initObservers(){

        viewModel.productData.observe(this) {

            if (it != null) {
                val list: MutableList<ProductsData> = mutableListOf()
                list.add(it)
                // submit list
                mainAdapter.submitList(list)
            }
        }

    }


}