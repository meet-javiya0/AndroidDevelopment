package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContactsMainScreen : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_main_screen)

        val etCName = findViewById<TextInputEditText>(R.id.etContactName)
        val etCEmail = findViewById<TextInputEditText>(R.id.etContactEmail)
        val etCNumber = findViewById<TextInputEditText>(R.id.etContactNumber)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnFind = findViewById<Button>(R.id.btnFind)

        btnSave.setOnClickListener {
            val contactName = etCName.text.toString()
            val email = etCEmail.text.toString()
            val number = etCNumber.text.toString()

            val contacts = Contacts(contactName, email, number)
            database = FirebaseDatabase.getInstance().getReference("Contacts")
            database.child(contactName).setValue(contacts).addOnSuccessListener {
                Toast.makeText(this, "Contact saved  successfully", Toast.LENGTH_SHORT).show()
                etCName.setText("")
                etCEmail.setText("")
                etCNumber.setText("")
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to save contact", Toast.LENGTH_SHORT).show()
            }

            btnFind.setOnClickListener {
                val intent = Intent(this, ContactSearchPage::class.java)
                startActivity(intent)
            }
        }
    }
}