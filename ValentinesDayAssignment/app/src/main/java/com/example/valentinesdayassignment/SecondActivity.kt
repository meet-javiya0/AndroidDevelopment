package com.example.valentinesdayassignment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val historyCard = findViewById<CardView>(R.id.history_card)
        val messageCard = findViewById<CardView>(R.id.message_card)

        historyCard.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }

        messageCard.setOnClickListener {
            val intent = Intent(this,Message::class.java)
            startActivity(intent)
        }
    }
}