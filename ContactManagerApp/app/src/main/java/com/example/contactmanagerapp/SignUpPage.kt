package com.example.contactmanagerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpPage : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etUserName = findViewById<TextInputEditText>(R.id.etUserName)
        val loginBtn = findViewById<Button>(R.id.btnLogin)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val username = etUserName.text.toString()

            val user = Users(name, email, password, username)
            databaseReference = FirebaseDatabase.getInstance().getReference("Users")
            databaseReference.child(username).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                etName.setText("")
                etEmail.setText("")
                etPassword.setText("")
                etUserName.setText("")
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
            }
        }

        loginBtn.setOnClickListener {
            val intentLoginPage = Intent(this, SignInPage::class.java)
            startActivity(intentLoginPage)
        }
    }
}