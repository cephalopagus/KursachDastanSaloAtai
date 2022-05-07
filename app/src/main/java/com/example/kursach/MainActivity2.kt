package com.example.kursach

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        login_enter.setOnClickListener{
            val strEmail = email.text.toString()
            val strPass = password.text.toString()

            if (strEmail.isNotEmpty() && strPass.isNotEmpty()){
                if ((strEmail.equals("d") && strPass.equals("d")) ||
                    (strEmail.equals("samosik.n@gmail.com") && strPass.equals("saloed228")) ||
                    (strEmail.equals("kirito29050213@gmail.com") && strPass.equals("atatam"))){
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(applicationContext, "Data entered incorrectly!", Toast.LENGTH_SHORT).show()

            }
            else if (strEmail.isEmpty() || strPass.isEmpty()){
                Toast.makeText(applicationContext, "Not all fields are filled!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}