package com.example.maro.proj2app1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ComponentName



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener { sendMessage() }
    }

    fun sendMessage() {
        val intent: Intent = Intent("maro.intent.action")
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        val message = etMessage.text.toString()
        intent.putExtra("maro.intent.key", message);
        intent.component = ComponentName("com.example.maro.proj2app2", "com.example.maro.proj2app2.App2BrodcastReciver")
//        intent.component = ComponentName("com.example.maro.proj2app3", "com.example.maro.proj2app3.ReciverService")
        sendBroadcast(intent, "com.example.maro.proj2app1.mypermission")
    }
}
