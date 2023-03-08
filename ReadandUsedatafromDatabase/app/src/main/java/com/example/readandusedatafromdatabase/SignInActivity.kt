package com.example.readandusedatafromdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference

    companion object{
        const val KEY1 = "com.example.readandusedatafromdatabase.mail"
        const val KEY2 = "com.example.readandusedatafromdatabase.name"
        const val KEY3 = "com.example.readandusedatafromdatabase.username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val userName = findViewById<TextInputEditText>(R.id.username)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = userName.text.toString()
            if (username.isNotEmpty()){
                readData(username)
            }
            else {
                Toast.makeText(this,"Please enter your Username!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(userName: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(userName).get().addOnSuccessListener {
            // If user exist
            if (it.exists()) {
                val email = it.child("email").value
                val name = it.child("name").value
                val username = it.child("username").value

                val intentWelcome = Intent(this,WelcomeActivity::class.java)
                intentWelcome.putExtra(KEY1,email.toString())
                intentWelcome.putExtra(KEY2, name.toString())
                intentWelcome.putExtra(KEY3, username.toString())
                startActivity(intentWelcome)
             }
            // If user not exist
            else {
                Toast.makeText(this,"User does not exist, Please register first!",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to load!, Please try again later", Toast.LENGTH_SHORT).show()
        }
    }
}