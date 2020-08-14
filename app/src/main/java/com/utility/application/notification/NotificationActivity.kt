package com.utility.application.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.utility.application.MainActivity
import com.utility.application.R
import com.utility.application.databinding.ActivityNotificationBinding
import kotlinx.android.synthetic.main.activity_notification.*


internal class NotificationActivity : AppCompatActivity() {

    private var notificationManager: NotificationManagerCompat? = null
    private lateinit var notificationReceiver: NotificationReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //creates channels for priority
        createNotificationChannels()

        //binding code
        val notificationBinding: ActivityNotificationBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_notification
            )
        notificationBinding.notificationActivity = this

        //creating notification manager
        notificationManager = NotificationManagerCompat.from(this)

        notificationReceiver = NotificationReceiver()
        registerReceiver(notificationReceiver, IntentFilter(ACTION_UPDATE_NOTIFICATION))
    }

    //for channel one level of notifications
    fun onClickChannelOne(view: View) {

        //creation of pending intent for when user clicks on the notification
        val notificationIntent = Intent(this, MainActivity::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            this,
            1, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )


        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_one)
            .setContentTitle(edit_text_title.text)
            .setContentText(edit_text_message.text)
            //setting priority will ensure that app wont crash for api level below OREO
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setSmallIcon(R.drawable.ic_menu_gallery)
            .setContentIntent(notificationPendingIntent)
            .setAutoCancel(true)
            .build()
        notificationManager?.notify(1, notification)
    }

    //for channel two level of notifications
    fun onClickChannelTwo(view: View) {
        val updateIntent = Intent(ACTION_UPDATE_NOTIFICATION)
        val updatePendingIntent = PendingIntent.getBroadcast(
            this,
            1,
            updateIntent,
            PendingIntent.FLAG_ONE_SHOT
        )
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            .setSmallIcon(R.drawable.ic_two)
            .setContentTitle(edit_text_title.text)
            .setContentText(edit_text_message.text)
            .setSmallIcon(R.drawable.ic_dashboard_black_24dp)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .addAction(R.drawable.ic_home_black_24dp, "Update Notification", updatePendingIntent)
            .build()
        notificationManager?.notify(2, notification)
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is Channel 1"


            val channel2 = NotificationChannel(
                CHANNEL_2_ID,
                "Channel 2",
                NotificationManager.IMPORTANCE_LOW
            )
            channel2.description = "This is Channel 2"


            val manager = getSystemService(
                NotificationManager::class.java
            )?.apply {
                createNotificationChannel(channel1)
                createNotificationChannel(channel2)
            }
        }
    }

    companion object {
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel2"
        private const val ACTION_UPDATE_NOTIFICATION =
            "com.utility.application.notifyme.ACTION_UPDATE_NOTIFICATION"
    }

    fun onCancelClick(view: View) {
        notificationManager?.cancel(1)
    }

    fun updateNotification() {
        val androidImage = BitmapFactory
            .decodeResource(resources, R.drawable.mascot_1)
        val notifyBuilder: NotificationCompat.Builder = getNotificationBuilder()
        notifyBuilder.setStyle(
            NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification Updated!")
        )

        notificationManager?.notify(1, notifyBuilder.build())
    }

    private fun getNotificationBuilder(): NotificationCompat.Builder {
        return NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setContentTitle("You've been notified!")
            .setContentText("This is your notification text.")
            .setSmallIcon(R.drawable.ic_home_black_24dp)
    }


    internal inner class NotificationReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            this@NotificationActivity.updateNotification()
        }
    }

    override fun onDestroy() {
        unregisterReceiver(notificationReceiver)
        super.onDestroy()
    }
}