package com.rsstudio.spark.save

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rsstudio.spark.R
import com.rsstudio.spark.base.BaseActivity
import com.rsstudio.spark.databinding.ActivitySaveBinding
import com.rsstudio.spark.databinding.ActivitySplashBinding

class SaveActivity : BaseActivity() {

    private lateinit var binding: ActivitySaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_save)
    }

    override fun onBackPressed() {
        finish()
        this.overridePendingTransition(R.anim.enter, R.anim.exit)
    }


}