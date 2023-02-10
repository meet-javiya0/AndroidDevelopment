package com.example.fullyfunctionalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class BlockchainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blockchain_page)

        val cardFrontEnd = findViewById<CardView>(R.id.FrontEndTechnologiesBlockchain)
        val cardBackEnd = findViewById<CardView>(R.id.BackEndTechnologiesBlockchain)
        val cardDatabase = findViewById<CardView>(R.id.DatabaseTechnologiesBlockchain)

        cardFrontEnd.setOnClickListener {
            val intent = Intent(applicationContext, FrontEndPageBlockchain::class.java)
            startActivity(intent)
        }

        cardBackEnd.setOnClickListener {
            val intent = Intent(applicationContext, BackEndPageBlockchain::class.java)
            startActivity(intent)
        }

        cardDatabase.setOnClickListener {
            val intent = Intent(applicationContext, DatabasePageBlockchain::class.java)
            startActivity(intent)
        }
    }
}