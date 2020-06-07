package com.utility.application.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.utility.application.R
import com.utility.application.databinding.ActivityArrayAdapterBinding

class ArrayAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityAdapterBinding: ActivityArrayAdapterBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_array_adapter
            )
        activityAdapterBinding.adapterActivity = this
    }

    fun onClickArrayAdapter(view: View) {
        intent = Intent()
        intent.setClass(this, NormalArrayAdapterActivity::class.java)
        startActivity(intent)
    }

    fun onClickCustomArrayAdapter(view: View) {
        intent = Intent()
        intent.setClass(this, CustomArrayAdapterActivity::class.java)
        startActivity(intent)
    }


}