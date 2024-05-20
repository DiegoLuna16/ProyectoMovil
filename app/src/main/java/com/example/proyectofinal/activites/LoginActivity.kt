package com.example.proyectofinal.activites

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()

        val textSignUp: TextView = findViewById(R.id.textSignUp)
        textSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setup() {
        val btnLogIn: MaterialButton = findViewById(R.id.btnHome)
        val editEmail: EditText = findViewById(R.id.editEmail)
        val editName: EditText = findViewById(R.id.editName)
        val editPass: EditText = findViewById(R.id.editPass)

        title = "Login"

        btnLogIn.setOnClickListener {
            if (editEmail.text.isNotEmpty() && editPass.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(editEmail.text.toString(), editPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val userEmail = it.result?.user?.email ?: ""
                            val userName = editName.text.toString()
                            if (userEmail == "admin@gmail.com") {
                                navigateToDatabaseActivity(userName, userEmail)
                            } else {
                                showMain(userName, userEmail)
                            }
                        } else {
                            showAlert()
                        }
                    }
            } else {
                showEmptyFieldsAlert()
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("An error occurred authenticating the user")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showMain(name: String, email: String) {
        val mainIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("name", name)
            putExtra("email", email)
        }
        startActivity(mainIntent)
    }

    private fun navigateToDatabaseActivity(name: String, email: String) {
        val databaseIntent = Intent(this, DatabaseActivity::class.java).apply {
            putExtra("name", name)
            putExtra("email", email)
        }
        startActivity(databaseIntent)
    }

    private fun showEmptyFieldsAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Empty Fields")
        builder.setMessage("Please fill in all the fields.")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}