package com.example.proyectofinal.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import com.google.android.material.button.MaterialButton


class DatabaseActivity : AppCompatActivity() {
    private lateinit var btnInsert: MaterialButton
    private lateinit var btnFetch : MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        btnInsert = findViewById(R.id.btnInsertion)
        btnFetch = findViewById(R.id.btnFetch)

        btnInsert.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }

        btnFetch.setOnClickListener {
            val intent = Intent(this, FetchActivity::class.java)
            startActivity(intent)
        }



    }
}