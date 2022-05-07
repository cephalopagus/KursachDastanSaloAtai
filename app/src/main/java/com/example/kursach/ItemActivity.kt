package com.example.kursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kursach.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding
    private var count: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.plus.setOnClickListener {
//            count++
//            binding.num.setText(count)
//        }
    }


//    fun setText(str: String) {
//        binding.num.append(str)
//
//    }

}