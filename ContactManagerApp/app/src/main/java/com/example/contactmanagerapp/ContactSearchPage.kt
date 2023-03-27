package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContactSearchPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    companion object {
        const val KEY1 = "com.example.contactmanagerapp.name"
        const val KEY2 = "com.example.contactmanagerapp.email"
        const val KEY3 = "com.example.contactmanagerapp.number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_search_page)

        val cName = findViewById<TextInputEditText>(R.id.etContactNameSearch)
        val btnFind = findViewById<Button>(R.id.btnFindSearch)

        btnFind.setOnClickListener {
            val contactName = cName.text.toString()
            if (contactName.isNotEmpty()) {
                readData(contactName)
            } else {
                Toast.makeText(this, "Please enter the contact name!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(contactName: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Contacts")
        databaseReference.child(contactName).get().addOnSuccessListener {
            if (it.exists() && (it.child("name").value == contactName)) {
                val email = it.child("email").value
                val name = it.child("name").value
                val number = it.child("number").value

                val intentContactData = Intent(this, ContactDetailsPage::class.java)
                intentContactData.putExtra(KEY1, name.toString())
                intentContactData.putExtra(KEY2, email.toString())
                intentContactData.putExtra(KEY3, number.toString())
                startActivity(intentContactData)
            } else {
                Toast.makeText(
                    this,
                    "Contact does not exist, Please add contact first!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load!, Please try again later!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}