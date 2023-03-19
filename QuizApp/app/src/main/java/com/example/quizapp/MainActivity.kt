package com.example.quizapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.q1.setOnClickListener {
            val options1 = arrayOf("int", "boolean", "double", "string")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which of the following is not a primitive data type in Java?")
            builder1.setSingleChoiceItems(options1, 0, DialogInterface.OnClickListener { _, which ->
                if (which == 3) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                }
            })
            builder1.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Submitted successfully!", Toast.LENGTH_SHORT).show()
            })
            builder1.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }

        binding.q2.setOnClickListener {
            val option2 = arrayOf("Python", "C++", "Java", "Ruby")
            val answer1 = booleanArrayOf(false, true, true, true)
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which of the following programming languages are object-oriented?")
            builder2.setMultiChoiceItems(
                option2,
                null,
                DialogInterface.OnMultiChoiceClickListener { _, which, isChecked ->
                    if (answer1[which] && isChecked) {
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    } else if (isChecked) {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                    }
                })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Submitted successfully!", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }

        binding.q3.setOnClickListener {
            val options3 = arrayOf("80", "443", "8080", "8443")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("What is the default port number for HTTP requests?")
            builder3.setSingleChoiceItems(options3, 0, DialogInterface.OnClickListener { _, which ->
                if (which == 0) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                }
            })
            builder3.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Submitted successfully!", Toast.LENGTH_SHORT).show()
            })
            builder3.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            })
            builder3.show()
        }

        binding.q4.setOnClickListener {
            val option4 = arrayOf("C#", "Swift", "HTML", "JavaScript")
            val answer2 = booleanArrayOf(false, true, false, true)
            val builder4 = AlertDialog.Builder(this)
            builder4.setTitle("Which of the following programming languages are used for developing mobile apps?")
            builder4.setMultiChoiceItems(
                option4,
                null,
                DialogInterface.OnMultiChoiceClickListener { _, which, isChecked ->
                    if (answer2[which] && isChecked) {
                        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    } else if (isChecked) {
                        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                    }
                })
            builder4.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Submitted successfully!", Toast.LENGTH_SHORT).show()
            })
            builder4.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            })
            builder4.show()
        }

        binding.q5.setOnClickListener {
            val options5 = arrayOf("iOS", "Android", "Windows", "Ubuntu")
            val builder5 = AlertDialog.Builder(this)
            builder5.setTitle("Which of the following is not a mobile operating system?")
            builder5.setSingleChoiceItems(options5, 0, DialogInterface.OnClickListener { _, which ->
                if (which == 3) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                }
            })
            builder5.setPositiveButton("Submit", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Submitted successfully!", Toast.LENGTH_SHORT).show()
            })
            builder5.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            })
            builder5.show()
        }

        binding.btnExit.setOnClickListener {
            val builder6 = AlertDialog.Builder(this)
            builder6.setTitle("Confirmation!")
            builder6.setMessage("Are you sure you want to exit?")
            builder6.setIcon(R.drawable.baseline_exit_to_app_24)
            builder6.setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                finish()
            })
            builder6.setNegativeButton("No", DialogInterface.OnClickListener { _, _ ->

            })
            builder6.show()
        }
    }
}