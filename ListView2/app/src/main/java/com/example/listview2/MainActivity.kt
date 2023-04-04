package com.example.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var userArrayLIst: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = arrayOf("Meet", "Jenny", "Sahil", "Ronak", "Saumya")
        val lastMsg = arrayOf(
            "Hey!",
            "Where are you?",
            "Join fast as soon as possible",
            "Which date is final?",
            "Early morning!"
        )
        val lastMsgTime = arrayOf("09:30", "09:15", "23:15", "22:10", "15:48")
        val phoneNumber =
            arrayOf("70123456891", "81023456792", "63012457893", "90321654874", "501245783695")
        val imageID = intArrayOf(
            R.drawable.person1,
            R.drawable.person0,
            R.drawable.person5,
            R.drawable.person3,
            R.drawable.person2
        )

        userArrayLIst = ArrayList()

        for (eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex], imageID[eachIndex])
            userArrayLIst.add(user)
        }

        val listView = findViewById<ListView>(R.id.listview)
        listView.isClickable = true

        listView.adapter = MyAdapter(this, userArrayLIst)
    }
}