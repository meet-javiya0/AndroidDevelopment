package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var totalTime: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<ImageView>(R.id.play)
        val btnPause = findViewById<ImageView>(R.id.pause)
        val btnStop = findViewById<ImageView>(R.id.stop)
        val varSeekBar = findViewById<SeekBar>(R.id.seekBar)

        mediaPlayer = MediaPlayer.create(this, R.raw.lets_crack_it)
        mediaPlayer.setVolume(1f, 1f)
        totalTime = mediaPlayer.duration

        btnPlay.setOnClickListener {
            mediaPlayer.start()
        }

        btnPause.setOnClickListener {
            mediaPlayer.pause()
        }

        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        // when user changes the time stamp of the music, reflect the changes
        varSeekBar.max = totalTime
        varSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        // change the seekbar position based on the music
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                try {
                    varSeekBar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (exception: java.lang.Exception) {
                    varSeekBar.progress = 0
                }
            }
        }, 0)
    }
}