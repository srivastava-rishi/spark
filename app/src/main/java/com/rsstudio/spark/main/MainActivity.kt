package com.rsstudio.spark.main


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsstudio.spark.R
import com.rsstudio.spark.adapter.MainAdapter
import com.rsstudio.spark.base.BaseActivity
import com.rsstudio.spark.databinding.ActivityMainBinding
import com.rsstudio.spark.model.ProductsData
import com.rsstudio.spark.save.SaveActivity
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
        initView()

        binding.iAppBar.ivMore.setOnClickListener{
            val intent = Intent(this@MainActivity, SaveActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
        }

    }

    private fun initView(){

        binding.iAppBar.searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(logTag, "onTextChanged: $s")
                mainAdapter.filter.filter(s)
            }
        })

    }

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.layoutManager = llm
        mainAdapter = MainAdapter(this)
        binding.rvProduct.adapter = mainAdapter
    }

    private fun initObservers() {

        viewModel.productData.observe(this) {

            if (it != null) {
                val list: MutableList<ProductsData> = mutableListOf()
                list.add(it)
                // submit list
                mainAdapter.submitList(list)
                binding.iAppBar.abRoot.visibility = View.VISIBLE
                binding.iLoader.visibility = View.GONE
            }
        }

    }

}