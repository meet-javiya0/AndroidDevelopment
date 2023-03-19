package com.example.customisedalertbox

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myBtn = findViewById<Button>(R.id.btnClickMe)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_alert_box)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        val btnGood = dialog.findViewById<Button>(R.id.btnGood)
        val btnFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        myBtn.setOnClickListener {
            dialog.show()
        }
        btnGood.setOnClickListener {
            Toast.makeText(this, "Thank you!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        btnFeedback.setOnClickListener {
            Toast.makeText(this, "Feedback submitted!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
    }
}