package com.example.kursach

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kursach.Data.ItemCartViewModel
import com.example.kursach.Data.User
import com.example.kursach.Data.UserViewModel
import com.example.kursach.databinding.ActivityUserBinding
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var newList: ArrayList<User>


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

        firebaseAuth = FirebaseAuth.getInstance()
        val hi = firebaseAuth.currentUser?.email
        val textView = findViewById<TextView>(R.id.email_profile).apply {
            text = hi
        }
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")

        binding.nameProfile.text = name
        binding.addressProfile.text = address
        binding.phoneProfile.text = phone




//        for (i in 0..userList.size){
//            val currentItem = userList[i]
//            if (currentItem.email == hi ){
//                binding.nameProfile.text = currentItem.name
//                binding.addressProfile.text = currentItem.address
//                binding.phoneProfile.text = currentItem.phone
//                break
//            }
//            else{
//                binding.nameProfile.text = "You haven't filled in the data"
//                binding.addressProfile.text = "You haven't filled in the data"
//                binding.phoneProfile.text = "You haven't filled in the data"
//            }
//        }



    }


}