package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CyberSecurityPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cyber_security_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologiesCyberSecurity)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologiesCyberSecurity)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologiesCyberSecurity)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPageCyberSecurity::class.java)
            startActivity(intent)
        }

        cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPageCyberSecurity::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePageCyberSecurity::class.java)
            startActivity(intent)
        }
    }
}