package com.example.multiscreenappdatapassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val tVOrder = findViewById<TextView>(R.id.tVOrder)
        val ordersOfCustomers = intent.getStringExtra(MainActivity.KEY)
        tVOrder.text = "Order Placed: " + ordersOfCustomers.toString()
    }
}