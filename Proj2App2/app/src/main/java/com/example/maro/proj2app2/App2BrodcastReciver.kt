package com.example.maro.proj2app2

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.widget.Toast
/**
 * Created by maro on 20.11.2017.
 */
class App2BrodcastReciver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("maro.intent.key")
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

        sendNotification(context!!, intent!!, message!!, "Notification sent....")
    }

//    fun sendNotification(context: Context, intent: Intent, title: String, body: String) {
//        val notification = NotificationCompat.Builder(context)
//                .setContentTitle(title)
//                .setContentText(body)
//
//        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
//
//        notification.setContentIntent(pendingIntent)
//        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.notify(1, notification.build())
//    }

    private fun sendNotification(context: Context, intent: Intent, title: String, body: String) {
//        val intent2 = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val notificationBuilder = NotificationCompat.Builder(context)
                .setContentText(body)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }
}