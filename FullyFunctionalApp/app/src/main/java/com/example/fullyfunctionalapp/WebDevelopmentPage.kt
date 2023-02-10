package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class WebDevelopmentPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_development_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologiesWeb)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologiesWeb)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologiesWeb)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPageWeb::class.java)
            startActivity(intent)
        }

        cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPageWeb::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePageWeb::class.java)
            startActivity(intent)
        }

    }
}