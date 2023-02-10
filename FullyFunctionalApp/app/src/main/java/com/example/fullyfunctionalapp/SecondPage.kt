package com.example.fullyfunctionalapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val cardAndroid = findViewById<CardView>(R.id.AndroidDevelopment)
        val cardWeb = findViewById<CardView>(R.id.WebDevelopment)
        val cardIOS = findViewById<CardView>(R.id.iOSDevelopment)
        val cardAIML = findViewById<CardView>(R.id.AI_ML)
        val cardBlockchain = findViewById<CardView>(R.id.Blockchain)
        val cardCyberSecurity = findViewById<CardView>(R.id.CyberSecurity)
        val btnCall = findViewById<Button>(R.id.btnCallUs)

        cardAndroid.setOnClickListener {
            val intent = Intent(applicationContext, AndroidDevelopmentPage::class.java)
            startActivity(intent)
        }

        cardWeb.setOnClickListener {
            val intent = Intent(applicationContext, WebDevelopmentPage::class.java)
            startActivity(intent)
        }

        cardIOS.setOnClickListener {
            val intent = Intent(applicationContext, iOSDevelopmentPage::class.java)
            startActivity(intent)
        }

        cardAIML.setOnClickListener {
            val intent = Intent(applicationContext, AI_ML_Page::class.java)
            startActivity(intent)
        }

        cardBlockchain.setOnClickListener {
            val intent = Intent(applicationContext, BlockchainPage::class.java)
            startActivity(intent)
        }

        cardCyberSecurity.setOnClickListener {
            val intent = Intent(applicationContext, CyberSecurityPage::class.java)
            startActivity(intent)
        }

        btnCall.setOnClickListener {
            dialPhoneNumber("0123456789")
        }
    }
    private fun dialPhoneNumber(phoneNumber:String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            Toast.makeText(applicationContext,"Dialer opened!", Toast.LENGTH_SHORT).show()
        }
    }
}