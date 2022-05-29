package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kursach.Data.ItemCart
import com.example.kursach.Data.ItemCartViewModel
import com.example.kursach.Data.UserViewModel
import com.example.kursach.databinding.ActivityItemBinding
import com.example.kursach.databinding.ActivitySettingBinding
import kotlinx.android.synthetic.main.activity_item.*
import java.util.ResourceBundle.getBundle

class ItemActivity : AppCompatActivity() {

    private lateinit var mItemCartViewModel: ItemCartViewModel
    private lateinit var binding: ActivityItemBinding
    var count: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle?= intent.extras
        val title = bundle?.getString("title")
        val pic = bundle?.getInt("pic")
        val cost = bundle?.getInt("cost")

        binding.detailTitle.text = title
        if (pic != null) {
            binding.detailImg.setImageResource(pic)
        }
        binding.detailCost.text ="$"+ cost


        binding.plus.setOnClickListener {
            count=count+1
            binding.num.text = count.toString()
            binding.detailCost.text = "$"+(count* cost!!)
        }
        binding.minus.setOnClickListener {
            if(count>1){
                count = count-1
            }
            binding.num.text = count.toString()
            binding.detailCost.text = "$"+(count* cost!!)
        }
        mItemCartViewModel =ViewModelProvider(this).get(ItemCartViewModel::class.java)

        binding.addBtn.setOnClickListener {
            insertDataToDatabase()
        }

    }

    private fun insertDataToDatabase() {
        val name = detail_title.text.toString()
        val count = num.text.toString()
        val price = detail_cost.text.toString()
        if (inputCheck(name, count, price)){
            val idRand = (15 .. 1000000).random()
            val itemCart = ItemCart(idRand, name, count, price)
            mItemCartViewModel.addItem(itemCart)
            Toast.makeText(this, "Added to Cart!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }


    }

    private fun inputCheck(name: String, count: String, price: String):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(count) && TextUtils.isEmpty(price))
    }
}