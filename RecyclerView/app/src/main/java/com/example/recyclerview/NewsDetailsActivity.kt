package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val heading = intent.getStringExtra("heading")
        val newsDesc = intent.getStringExtra("newsDesc")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)

        val headingTV = findViewById<TextView>(R.id.tVHeadingTitle)
        val imageNews = findViewById<ImageView>(R.id.iVNews)
        val newsDescription = findViewById<TextView>(R.id.tVNewsDesc)

        headingTV.text = heading
        imageNews.setImageResource(imageId)
        newsDescription.text = newsDesc
    }
}