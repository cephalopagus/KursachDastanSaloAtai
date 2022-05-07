package com.example.kursach.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.ItemActivity
import com.example.kursach.R

class Horizontal_RecyclerView: RecyclerView.Adapter<Horizontal_RecyclerView.myViewHolder>() {

    class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener{

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_row, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }



}