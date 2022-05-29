package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kursach.Data.User
import com.example.kursach.Data.UserViewModel

import com.example.kursach.databinding.ActivitySettingBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.completeSetting.setOnClickListener {
            //insertDataToDatabase()
            intentData()
        }
    }

    private fun intentData() {
        val name = name_setting.text.toString()
        val address = address_setting.text.toString()
        val phone = phone_setting.text.toString()
        val intent = Intent(this, UserActivity::class.java).also {
            it.putExtra("name", name)
            it.putExtra("address", address)
            it.putExtra("phone", phone)
            startActivity(it)
        }
    }

    private fun insertDataToDatabase() {
        firebaseAuth = FirebaseAuth.getInstance()
        val email = firebaseAuth.currentUser?.email.toString()
        val firstName = name_setting.text.toString()
        val address = address_setting.text.toString()
        val phone = phone_setting.text.toString()


        if (inputCheck(firstName, address, phone)){
            val idRand = (15 .. 1000000).random()
            val user = User(idRand,email, firstName, address, phone)
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Successfully added!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(firstName: String, address: String, phone: String):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(address) && TextUtils.isEmpty(phone))
    }
}