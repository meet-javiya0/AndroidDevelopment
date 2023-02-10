package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSecond = findViewById<Button>(R.id.button)

        btnSecond.setOnClickListener {
            intent = Intent(applicationContext, SecondPage::class.java)
            startActivity(intent)
        }
    }
}