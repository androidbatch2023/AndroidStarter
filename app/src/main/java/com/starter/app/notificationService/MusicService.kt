package com.starter.app.notificationService

import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.support.v4.media.session.MediaSessionCompat
import androidx.core.app.NotificationCompat
import com.starter.app.R

class MusicService : Service() {
    private var myBinder = MyBinder()
    var mediaPlayer: MediaPlayer? = null
    private lateinit var mediaSession: MediaSessionCompat
    override fun onBind(intent: Intent?): IBinder? {
        mediaSession = MediaSessionCompat(baseContext, "My Music Notification")
        return myBinder//bhargav:glpat-23bVocHEEAsvYcCecPc2
    }//https://bhargav:glpat-23bVocHEEAsvYcCecPc2@gitlab.devhyper.link/bhargavS/firstproject/-/tree/main

    inner class MyBinder : Binder() {
        fun currentService(): MusicService {
            return this@MusicService
        }
    }

    fun showNotification() {
        val notification = NotificationCompat.Builder(baseContext, "CHANNEL_ID")
            .setContentTitle("Music Notification")
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentText("Hello Notification")
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.project_icon))
            .setStyle(
                androidx.media.app.NotificationCompat.MediaStyle()
                    .setMediaSession(mediaSession.sessionToken)
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setOnlyAlertOnce(true)
            .addAction(R.drawable.project_icon, "", null)
            .build()

        startForeground(13, notification)
    }
}