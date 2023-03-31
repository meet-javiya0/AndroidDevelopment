package com.example.contactmanagerapp

import android.annotation.SuppressLint
import android.app.Dialog
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
    private lateinit var dialog: Dialog
    @SuppressLint("ResourceType", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts_main_screen)

        val etCName = findViewById<TextInputEditText>(R.id.etContactName)
        val etCEmail = findViewById<TextInputEditText>(R.id.etContactEmail)
        val etCNumber = findViewById<TextInputEditText>(R.id.etContactNumber)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnFind = findViewById<Button>(R.id.btnFind)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.okay_alert_box)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_okay_alert_box))
        val btnOkay = dialog.findViewById<Button>(R.id.btnOkay)

        btnFind.setOnClickListener {
            val intent = Intent(this, ContactSearchPage::class.java)
            startActivity(intent)
        }

        btnOkay.setOnClickListener {
            dialog.dismiss()
        }

        btnSave.setOnClickListener {
            val contactName = etCName.text.toString()
            val email = etCEmail.text.toString()
            val number = etCNumber.text.toString()

            val contacts = Contacts(contactName, email, number)
            database = FirebaseDatabase.getInstance().getReference("Contacts")
            database.child(contactName).setValue(contacts).addOnSuccessListener {
                dialog.show()
                etCName.setText("")
                etCEmail.setText("")
                etCNumber.setText("")
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to save contact", Toast.LENGTH_SHORT).show()
            }
        }
    }
}