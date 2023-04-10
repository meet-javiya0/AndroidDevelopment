package com.example.listview2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class UserActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("phone")
        val imgId = intent.getIntExtra("imgId", R.drawable.person1)

        val personName = findViewById<TextView>(R.id.name)
        val personNumber = findViewById<TextView>(R.id.number)
        val imageID = findViewById<ImageView>(R.id.profile_image)

        personName.text = "Name: $name"
        personNumber.text = "Number: $number"
        imageID.setImageResource(imgId)
    }
}