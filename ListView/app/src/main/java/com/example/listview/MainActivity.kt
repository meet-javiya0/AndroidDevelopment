package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.listView)
        val taskList = arrayListOf<String>()

        taskList.add("Attend exam")
        taskList.add("Complete App Dev Tutorial")
        taskList.add("Buy stationary")
        taskList.add("Update resume")
        taskList.add("Improve internet presence")
        taskList.add("Complete Assignment")

        val adapterForMyList = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)

        listview.adapter = adapterForMyList

        listview.setOnItemClickListener { adapterView, view, i, l ->
            val text = "Clicked on item: " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}