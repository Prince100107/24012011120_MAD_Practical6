package com.example.a24012011120_mad_practical6

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    companion object{
        val SERVICE_DATA="password1"
        val SERVICE_KEY="playpause"
    }
    lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this :: mediaPlayer.isInitialized)
            mediaPlayer = MediaPlayer.create(this,R.raw.song)
        if(intent != null){
            val str1: String?=intent.getStringExtra("password1")
            if(str1=="playpause"){
                if(!mediaPlayer.isPlaying){
                    mediaPlayer.start()
                }else{
                    mediaPlayer.pause()
                }
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}