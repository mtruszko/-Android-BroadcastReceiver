package com.example.maro.proj2app3

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log

/**
 * Created by maro on 21.11.2017.
 */
class ReciverService : Service() {
    override fun onCreate() {
        // Service needs the LocalBroadcastManager, too
        val localBroadcastManager = LocalBroadcastManager.getInstance(this)

        // Start listening for relevant events BEFORE announcing readiness...
        // that's basically the whole point of announcing ready.
        localBroadcastManager.registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                // Service can take appropriate action now
                Log.i("APP", "Service got intent with action: ${intent.action} and operation ${intent.getStringExtra("operation")}")
            }
        }, IntentFilter(ACTION_SERVER_MESSAGE))

        // Everything is squared away, let's signal we can start handling messages.
        localBroadcastManager.sendBroadcast(Intent(ACTION_SERVER_READY))
    }

    override fun onBind(intent: Intent): IBinder = null

    // Keep our actions in constants
    companion object {
        const val ACTION_SERVER_READY = "serverReady"
        const val ACTION_SERVER_MESSAGE = "serverMessage"
    }
}