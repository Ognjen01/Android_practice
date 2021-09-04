package com.ognjenlazic.testing

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notification.*

class Notification : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        createNotificationChannel()


        val intent = Intent(this, Notification :: class.java)
        val padingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }



        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awsome notification")
            .setContentText("This is contetnt text")
            .setSmallIcon(R.drawable.ic_message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(padingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)


        btnShowNot.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }

    }


    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.RED
                enableLights(true)
            }

            val menager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            menager.createNotificationChannel(channel)

        }
    }

}
