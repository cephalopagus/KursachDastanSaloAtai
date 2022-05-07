package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kursach.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
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
        binding.settingProfile.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }


        val info_profile = intent.getStringExtra("name")
        val info_profile1 = intent.getStringExtra("address")
        val info_profile2 = intent.getStringExtra("phone")
        val textView = findViewById<TextView>(R.id.name_profile).apply {
            text = info_profile
        }
        val textView1 = findViewById<TextView>(R.id.address_profile).apply {
            text = info_profile1
        }
        val textView2 = findViewById<TextView>(R.id.phone_profile).apply {
            text = info_profile2
        }
    }
}