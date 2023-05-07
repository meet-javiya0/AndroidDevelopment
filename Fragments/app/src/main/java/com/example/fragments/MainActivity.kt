package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClock = findViewById<Button>(R.id.btnTime)
        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnClock.setOnClickListener {
            replaceFrameWithFragment(Clock_Fragment())
        }

        btnExam.setOnClickListener {
            replaceFrameWithFragment(Exam_Fragment())
        }

        btnValidate.setOnClickListener {
            replaceFrameWithFragment(Validate_Fragment())
        }
    }

    private fun replaceFrameWithFragment(frag: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.frameLayout, frag)
        fragTransaction.commit()
    }
}