package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class AI_ML_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_ml_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologiesAIML)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologiesAIML)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologiesAIML)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPageAI_ML::class.java)
            startActivity(intent)
        }

        cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPageAI_ML::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePageAI_ML::class.java)
            startActivity(intent)
        }
    }
}