package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.Adapter.Vertical_RecyclerView
import com.example.kursach.Data.ItemCartViewModel
import com.example.kursach.databinding.ActivityListBinding
import kotlinx.android.synthetic.main.activity_home.*

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mItemCartViewModel: ItemCartViewModel

    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
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
        binding.payBtn.setOnClickListener{
            deleteAllItems()
            Toast.makeText(this, "Payment Completed Successfully", Toast.LENGTH_LONG).show()
        }


        recyclerView = findViewById(R.id.recyclerViewList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        val adapter = Vertical_RecyclerView()
        recyclerView.adapter = adapter


        mItemCartViewModel = ViewModelProvider(this).get(ItemCartViewModel::class.java)
        mItemCartViewModel.readAllItemData.observe(this, Observer { item ->
            adapter.setData(item)

        })
    }
    private fun deleteAllItems() {
        mItemCartViewModel.deleteAllItems()
    }
}