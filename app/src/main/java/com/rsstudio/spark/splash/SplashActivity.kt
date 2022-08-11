package com.rsstudio.spark.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.rsstudio.spark.R
import com.rsstudio.spark.base.BaseActivity
import com.rsstudio.spark.databinding.ActivityBaseBinding
import com.rsstudio.spark.databinding.ActivitySplashBinding
import com.rsstudio.spark.main.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        //
//        initTheme()
        gotoMainActivity()
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.white2)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }

    private fun gotoMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 500
        )
    }

}