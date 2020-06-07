package com.utility.application

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.utility.application.adapter.ArrayAdapterActivity
import com.utility.application.databinding.ActivityMainBinding
import com.utility.application.notification.NotificationActivity
import com.utility.application.snackbar.SnackBarActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.mainActivity = this
    }

    fun onClickSnackBar(view: View) {
        intent = Intent()
        intent.setClass(this, SnackBarActivity::class.java)
        startActivity(intent)
    }

    fun onClickNotification(view: View) {
        intent = Intent()
        intent.setClass(this, NotificationActivity::class.java)
        startActivity(intent)
    }

    fun onClickAdapter(view: View) {
        intent = Intent()
        intent.setClass(this, ArrayAdapterActivity::class.java)
        startActivity(intent)
    }
}
