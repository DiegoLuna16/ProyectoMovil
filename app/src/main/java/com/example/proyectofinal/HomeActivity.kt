package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email?:"",provider?:"")
    }

    private fun setup(email : String, provider: String){

        title = "Home"

        val btnSignOut : Button = findViewById(R.id.btnSignOut)
        val textEmail : TextView = findViewById(R.id.textEmail)
        val textPass : TextView = findViewById(R.id.textPassword)

        textEmail.text = email
        textPass.text = provider

        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

    }
}