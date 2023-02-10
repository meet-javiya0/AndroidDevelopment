package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class iOSDevelopmentPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ios_development_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologiesIOS)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologiesIOS)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologiesIOS)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPageiOS::class.java)
            startActivity(intent)
        }

        cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPageiOS::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePageiOS::class.java)
            startActivity(intent)
        }
    }
}