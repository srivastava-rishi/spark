package com.rsstudio.spark.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rsstudio.spark.R
import com.rsstudio.spark.databinding.ActivityBaseBinding
import com.rsstudio.spark.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        //
        initTheme()
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.white2)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }

}