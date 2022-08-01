package com.dungnd.android23

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class PlaySongService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O)
            startMyOwnForeground()
        else startForeground(1, Notification())
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource("https://laylink.vip/acdn/aHR0cHMlM0ElMkYlMkZtcDMtczEtbS16bXAzLnptZGNkbi5tZSUyRjJlYzlhMGJjNzZmZDlmYTNjNmVjJTJGNjY2NzUwMTk1NDg0MzM5NDQ4MyUzRmF1dGhlbiUzRGV4cCUzRDE2NTk0NTUxMjglN0VhY2wlM0QlMkYyZWM5YTBiYzc2ZmQ5ZmEzYzZlYyUyRiUyQSU3RWhtYWMlM0Q0NGJhNTVmZmJmZmJhMjVhNTk2MDRkMjYxZjRmMDAxYSUyNmZzJTNETVRZMU9USTRNak15T0RZNU9YeDNaV0pXTkh3eE1ETWRVbmdPUzQzT0M0NE5B")
            prepare() // might take long! (for buffering, etc)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startMyOwnForeground() {
        val NOTIFICATION_CHANNEL_ID = "example.permanence"
        val channelName = "Background Service"
        val chan = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        val notification = notificationBuilder.setOngoing(true)
            .setContentTitle("App is running in background")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }

    override fun onBind(intent: Intent): IBinder? = null

    /* Phương thức onStartCommand() trả về kiểu integer, và là một trong các giá trị sau:
     START_STICKY
     START_NOT_STICKY
     TART_REDELIVER_INTENT
     Cả hai giá trị này chỉ thích hợp khi điện thoại hết bộ nhớ và giết các dịch vụ trước khi nó kết thúc thực hiện.
     START_STICKY nói với các hệ điều hành để tạo lại các dịch vụ sau khi đã có đủ bộ nhớ và gọi onStartCommand()
     một lần nữa với một Intent null.
     START_NOT_STICKY nói với các hệ điều hành để không bận tâm tái tạo các dịch vụ một lần nữa.
     Ngoài ra còn có một START_REDELIVER_INTENT giá trị thứ ba mà nói với các hệ điều hành để tạo lại
     các dịch vụ và truyền một Intent tương tự cho onStartCommand().*/
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()

        val broadcastIntent = Intent()
        broadcastIntent.action = "restartservice"
        broadcastIntent.setClass(this, Restarter::class.java)
        this.sendBroadcast(broadcastIntent)
    }
}