package com.example.recyclerview

import android.content.Intent
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
            R.drawable.img6,
            R.drawable.img7,
        )

        val newsHeadingArray = arrayOf(
            "6 must-watch tech startup movies and shows for budding entrepreneurs",
            "77-foot asteroid approaching! Know what NASA has revealed",
            "Global PC shipments slide in Q1, Apple takes biggest hit",
            "Top 10 Big Data Technologies That You Need to Know in 2023",
            "AI's Delhi-San Francisco plane suffers tech issue before take off; airline replaces aircraft",
            "Apple Watch straps could track your hand gestures, patent suggests"
        )

        val newsDesc = arrayOf(
            getString(R.string.news_desc1),
            getString(R.string.news_desc2),
            getString(R.string.news_decs3),
            getString(R.string.news_desc4),
            getString(R.string.news_desc5),
            getString(R.string.news_desc6)
        )

        // to set ha bhav of items inside recycleView, vertical scrolling, horizontally, uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf()

        for (index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsDesc[index])
            newsArrayList.add(news)
        }

        val myAdapter = MyAdapter(newsArrayList)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClicking(position: Int) {
                val intent = Intent(this@MainActivity, NewsDetailsActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsDesc", newsArrayList[position].newsDesc)
                startActivity(intent)
            }
        })
    }
}