package com.dungnd.android23

import android.app.Application
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.dungnd.android23.buoi8.AppRoomDatabase
import com.dungnd.android23.buoi9.NetworkChangeReceiver

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //chuyển vào 1 activity nào đó cần lắng nghe sự thay đổi của broadcast
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }
        registerReceiver(NetworkChangeReceiver(), filter)
    }
}