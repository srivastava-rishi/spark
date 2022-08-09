package com.rsstudio.spark.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rsstudio.spark.R
import com.rsstudio.spark.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    var logTag = "@MainActivity"

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()


    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.white2)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }



}