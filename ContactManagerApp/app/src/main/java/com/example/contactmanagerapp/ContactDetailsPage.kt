package com.example.contactmanagerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ContactDetailsPage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details_page)

        val cName = intent.getStringExtra(ContactSearchPage.KEY1)
        val cEmail = intent.getStringExtra(ContactSearchPage.KEY2)
        val cNumber = intent.getStringExtra(ContactSearchPage.KEY3)

        if (cName != null && cEmail != null && cNumber != null) {
            val contactName = findViewById<TextView>(R.id.tVContactUsername)
            val mailText = findViewById<TextView>(R.id.tVContactEmail)
            val numberText = findViewById<TextView>(R.id.tVContactNumber)

            contactName.text = "Contact Name: $cName"
            mailText.text = "Email: $cEmail"
            numberText.text = "Phone number: $cNumber"
        } else {
            Toast.makeText(this, "User data not found!", Toast.LENGTH_SHORT).show()
        }
    }
}