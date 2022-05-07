package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.kursach.databinding.ActivitySettingBinding
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : AppCompatActivity() {

    var info_set: ArrayList<String> = ArrayList()
    private lateinit var binding: ActivitySettingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
//        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
//        binding.completeSetting.setOnClickListener {
//            insertDataToDatabase()
//
//        }
        setContentView(binding.root)

        /*val nameSet = name_setting.text.toString()
        val addressSet = address_setting.text.toString()
        val phoneSet = phone_setting.text.toString()*/



    }
//    private fun insertDataToDatabase(){
//        val nameSet = name_setting.text.toString()
//        val addressSet = address_setting.text.toString()
//        val phoneSet = phone_setting.text.toString()
//        val add = "dastan@"
//
//        val user = User(0, nameSet, addressSet, phoneSet)
//        mUserViewModel.addUser(user)
//
//
//    }

}