package com.utility.application

import android.app.Notification
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.utility.application.App.Companion.CHANNEL_1_ID
import com.utility.application.App.Companion.CHANNEL_2_ID
import com.utility.application.databinding.ActivityNotificationBinding
import kotlinx.android.synthetic.main.activity_notification.*


class NotificationActivity : AppCompatActivity() {

    private var notificationManager: NotificationManagerCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val notificationBinding: ActivityNotificationBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_notification)
        notificationManager = NotificationManagerCompat.from(this)
        notificationBinding.notificationActivity = this
    }

    //for channel one level of notifications
    fun onClickChannelOne(view: View) {
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_one)
            .setContentTitle(edit_text_title.text)
            .setContentText(edit_text_message.text)
            //setting priority will ensure that app wont crash for api level below OREO
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManager?.notify(1, notification)
    }

    //for channel two level of notifications
    fun onClickChannelTwo(view: View) {
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            .setSmallIcon(R.drawable.ic_two)
            .setContentTitle(edit_text_title.text)
            .setContentText(edit_text_message.text)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        notificationManager?.notify(2, notification)
    }

}