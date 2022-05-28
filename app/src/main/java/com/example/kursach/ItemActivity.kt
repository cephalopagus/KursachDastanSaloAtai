package com.example.kursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kursach.databinding.ActivityItemBinding
import java.util.ResourceBundle.getBundle

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle: Bundle?= intent.extras
        val title = bundle?.getString("title")
        val pic = bundle?.getInt("pic")
        val cost = bundle?.getString("cost")

        binding.detailTitle.text = title
        if (pic != null) {
            binding.detailImg.setImageResource(pic)
        }
        binding.detailCost.text = cost

    }



}