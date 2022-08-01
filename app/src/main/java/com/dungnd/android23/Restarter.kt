package com.dungnd.android23

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.dungnd.android23.PlaySongService

class Restarter : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(Intent(context, PlaySongService::class.java))
        } else {
            context.startService(Intent(context, PlaySongService::class.java))
        }
    }
}