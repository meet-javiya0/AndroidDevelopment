package com.example.multiscreenappdatapassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order.*

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val ordersOfCustomers = intent.getStringExtra(MainActivity.KEY)
        tVOrder.text = "Order Placed: " + ordersOfCustomers.toString()
    }
}