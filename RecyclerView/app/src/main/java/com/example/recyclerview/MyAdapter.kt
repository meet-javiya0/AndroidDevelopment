package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newsArrayList: ArrayList<News>, val context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView)
    }

    // populate item with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
    }

    // returns that how many items are present in our array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // It holds the view so views are not created at everytime, so memory can be saved
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headingTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val headingImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)
    }
}