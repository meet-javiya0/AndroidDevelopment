package com.example.photoframeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var currentImage = 0
    private lateinit var image: ImageView
    private var names = arrayOf("Mahatma Gandhi","Narendra Modi","Mary Kom","Saina Nehwal","Ratan Tata","Sundar Pichai")

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.imgPrevBtn)
        val next = findViewById<ImageButton>(R.id.imgNextBtn)
        val text = findViewById<TextView>(R.id.personName)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6 + currentImage - 1) % 6
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            val idCurrentImageInt =
                this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6 + currentImage + 1) % 6
            val idImageToShowString = "pic$currentImage"
            val idImageToShowInt =
                this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]
        }
    }
}