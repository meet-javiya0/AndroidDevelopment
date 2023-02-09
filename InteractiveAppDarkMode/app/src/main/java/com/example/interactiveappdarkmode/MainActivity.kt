package com.example.interactiveappdarkmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDarkMode = findViewById<Button>(R.id.btnDarkMode)
        val buttonLightMode = findViewById<Button>(R.id.btnLightMode)
        val buttonReadingMode = findViewById<Button>(R.id.btnReadingMode)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        buttonDarkMode.setOnClickListener {
            layout.setBackgroundResource(R.color.black)
            Toast.makeText(applicationContext,"Dark Mode Enabled",Toast.LENGTH_SHORT).show()
        }

        buttonLightMode.setOnClickListener {
            layout.setBackgroundResource(R.color.white)
            Toast.makeText(applicationContext,"Light Mode Enabled",Toast.LENGTH_SHORT).show()
        }

        buttonReadingMode.setOnClickListener {
            layout.setBackgroundResource(R.color.yellow)
            Toast.makeText(applicationContext,"Reading Mode Enabled",Toast.LENGTH_SHORT).show()
        }
    }
}