package com.example.readandusedatafromdatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(SignInActivity.KEY2)
        val email = intent.getStringExtra(SignInActivity.KEY1)
        val username = intent.getStringExtra(SignInActivity.KEY3)

        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val mailText = findViewById<TextView>(R.id.tVEmail)
        val usernameText = findViewById<TextView>(R.id.tVUsername)

        welcomeText.text = "Welcome $name"
        mailText.text = "Email: $email"
        usernameText.text = "Username: $username"
    }
}