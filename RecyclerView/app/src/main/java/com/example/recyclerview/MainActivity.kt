package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
        )
        val newsHeadingArray = arrayOf(
            "6 must-watch tech startup movies and shows for budding entrepreneurs",
            "77-foot asteroid approaching! Know what NASA has revealed",
            "Global PC shipments slide in Q1, Apple takes biggest hit",
            "Top 10 Big Data Technologies That You Need to Know in 2023",
            "Apple’s 40% Plunge in PC Shipments Is Steepest Among Major Computer Makers",
            "AI's Delhi-San Francisco plane suffers tech issue before take off; airline replaces aircraft",
            "Apple Watch straps could track your hand gestures, patent suggests"
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf()

        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index], newsImageArray[index])
            newsArrayList.add(news)
        }

        myRecyclerView.adapter = MyAdapter(newsArrayList, this)
    }
}