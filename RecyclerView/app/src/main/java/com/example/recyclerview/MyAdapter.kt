package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newsArrayList: ArrayList<News>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //created variable of type interface
    private lateinit var myListener: OnItemClickListener

    // created interface and make function in it
    interface OnItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        myListener = listener
    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // populate item with data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.headingTitle.text = currentItem.newsHeading
        holder.headingImage.setImageResource(currentItem.newsImage)
    }

    // returns that how many items are present in our array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // It holds the view so views are not created at everytime, so memory can be saved
    class MyViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val headingTitle: TextView = itemView.findViewById(R.id.headingTitle)
        val headingImage: ShapeableImageView = itemView.findViewById(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }
}