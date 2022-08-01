package com.dungnd.android23

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class PlaySongBinderService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private var binder: IBinder = PlaySongBinder()

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.send_it)
        mediaPlayer?.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )
    }

    override fun onBind(intent: Intent): IBinder = binder

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }

    fun startMusic() {
        mediaPlayer?.start()
    }

    inner class PlaySongBinder : Binder() {
        fun getService(): PlaySongBinderService {
            return this@PlaySongBinderService
        }
    }
}