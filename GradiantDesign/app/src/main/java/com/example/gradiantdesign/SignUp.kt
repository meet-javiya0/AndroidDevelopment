package com.example.gradiantdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.math.sign

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signUpButton = findViewById<Button>(R.id.button)

        signUpButton.setOnClickListener {
            Toast.makeText(applicationContext,"Singed Up Successfully", Toast.LENGTH_SHORT).show()
        }
    }
}