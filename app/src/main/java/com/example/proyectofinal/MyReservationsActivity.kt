package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MyReservationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_reservations)

        val nameTxt = findViewById<TextView>(R.id.textName)
        val dayTxt = findViewById<TextView>(R.id.textDay)
        val timeTxt = findViewById<TextView>(R.id.textTime)

        val name = intent.getStringExtra("name")
        val day = intent.getStringExtra("day")
        val time = intent.getStringExtra("time")

        nameTxt.text = name
        dayTxt.text = day
        timeTxt.text = time

        val btnHome = findViewById<MaterialButton>(R.id.btnHome)

        btnHome.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }


}

