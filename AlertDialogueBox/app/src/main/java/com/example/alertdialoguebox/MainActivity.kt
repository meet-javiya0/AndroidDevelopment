package com.example.alertdialoguebox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Confirmation!")
            builder1.setMessage("Are you sure you want to exit?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { _, _ ->

            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "Rasmalai", "Kaju katli")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite item from below list?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { _, which ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Reply submitted successfully", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { _, _ ->

            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab jamun", "Rasmalai", "Kaju katli")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Select all your favourite items")
            builder3.setMultiChoiceItems(
                options,
                null,
                DialogInterface.OnMultiChoiceClickListener { _, which, _ ->
                    Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Reply submitted successfully", Toast.LENGTH_SHORT).show()
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { _, _ ->

            })
            builder3.show()
        }
    }
}