package com.utility.application

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.utility.application.adapter.ArrayAdapterActivity
import com.utility.application.alarm.AlarmActivity
import com.utility.application.api.ApiActivity
import com.utility.application.async.AsyncActivity
import com.utility.application.broadcasts.BroadcastActivity
import com.utility.application.databinding.ActivityMainBinding
import com.utility.application.drawer.DrawerActivity
import com.utility.application.navbar.NavbarActivity
import com.utility.application.notification.NotificationActivity
import com.utility.application.recyclerview.RecyclerViewActivity
import com.utility.application.snackbar.SnackBarActivity
import com.utility.application.tabs.TabActivity


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

    fun onClickRecyclerView(view: View) {
        intent = Intent()
        intent.setClass(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    fun onTabsClick(view: View) {
        intent = Intent()
        intent.setClass(this, TabActivity::class.java)
        startActivity(intent)
    }

    fun onNavbarClick(view: View) {
        intent = Intent()
        intent.setClass(this, NavbarActivity::class.java)
        startActivity(intent)
    }

    fun onDrawerClick(view: View) {
        intent = Intent()
        intent.setClass(this, DrawerActivity::class.java)
        startActivity(intent)
    }

    fun onAsyncClick(view: View) {
        intent = Intent()
        intent.setClass(this, AsyncActivity::class.java)
        startActivity(intent)
    }

    fun onApiCall(view: View) {
        intent = Intent()
        intent.setClass(this, ApiActivity::class.java)
        startActivity(intent)
    }

    fun onBroadcast(view: View) {
        intent = Intent()
        intent.setClass(this, BroadcastActivity::class.java)
        startActivity(intent)
    }

    fun onAlarmClick(view: View) {
        intent = Intent()
        intent.setClass(this, AlarmActivity::class.java)
        startActivity(intent)
    }


}
