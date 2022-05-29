package com.example.kursach.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.Domain.ItemDomain
import com.example.kursach.R

class Horizontal_RecyclerView(private val itemList: ArrayList<ItemDomain>): RecyclerView.Adapter<Horizontal_RecyclerView.myViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener:onItemClickListener){
        mListener = listener
    }


    class myViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val itemImg :ImageView = itemView.findViewById(R.id.image_item)
        val itemTitle :TextView = itemView.findViewById(R.id.title_item)
        val itemCost :TextView = itemView.findViewById(R.id.cost_item)

        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_row, parent, false)
        return myViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.itemImg.setImageResource(currentItem.pic)
        holder.itemTitle.text = currentItem.title
        holder.itemCost.text = "$"+currentItem.cost

    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}