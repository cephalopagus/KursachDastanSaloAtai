package com.example.kursach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kursach.fragments.AccountFragment
import com.example.kursach.fragments.HomeFragment
import com.example.kursach.fragments.ListFragment
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val accountFragment = AccountFragment()
    private val listFragment = ListFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        replaceFragment(homeFragment)
        button_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_ic -> replaceFragment(homeFragment)
                R.id.list_ic -> replaceFragment(listFragment)
                R.id.user_ic -> replaceFragment(accountFragment)
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

}