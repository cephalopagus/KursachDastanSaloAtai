package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.Adapter.Horizontal_RecyclerView
import com.example.kursach.Domain.ItemDomain
import com.example.kursach.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_row.*

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemDomain>

    private lateinit var binding: ActivityHomeBinding

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var cost: Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.navList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        binding.navUser.setOnClickListener {
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
        binding.errorPage.setOnClickListener {
            Toast.makeText(this, "This page is not exist :)", Toast.LENGTH_SHORT).show()
        }
        image = arrayOf(
            R.drawable.washing_machine,
            R.drawable.vacuum_cleaner,
            R.drawable.meatmurder,
            R.drawable.dishwasher
        )
        title = arrayOf(
            "LG Washing Machine",
            "House Cleaning Samsung",
            "Meat Grinder Garlyn",
            "Dishwasher Siemens"

        )
        cost = arrayOf(
            230,
            110,
            80,
            90
        )




        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ItemDomain>()
        getDataItem()

    }

    private fun getDataItem() {
        for (i in image.indices){
            val item = ItemDomain(
                image[i], title[i], cost[i]
            )
            newArrayList.add(item)
        }

        var adapter = Horizontal_RecyclerView(newArrayList)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : Horizontal_RecyclerView.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@HomeActivity, "Click on $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@HomeActivity, ItemActivity::class.java)
                intent.putExtra("title",newArrayList[position].title)
                intent.putExtra("pic",newArrayList[position].pic)
                intent.putExtra("cost",newArrayList[position].cost)
                startActivity(intent)
            }

        })




    }

}