package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class AndroidDevelopmentPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_development_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologies)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologies)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologies)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPage::class.java)
            startActivity(intent)
        }

         cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPage::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePage::class.java)
            startActivity(intent)
        }
    }
}