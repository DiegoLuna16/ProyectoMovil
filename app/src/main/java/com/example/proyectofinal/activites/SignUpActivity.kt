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

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setup()

        val textLogIn: TextView = findViewById(R.id.textLogIn)

        textLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            title = "Login"
        }

    }

    private fun setup() {
        val btnSignUp: MaterialButton = findViewById(R.id.btnSignUp)
        val editName: EditText = findViewById(R.id.editName)
        val editEmail: EditText = findViewById(R.id.editEmail)
        val editPass: EditText = findViewById(R.id.editPass)
        val editPass2: EditText = findViewById(R.id.editPass2)

        title = "Login"

        btnSignUp.setOnClickListener {
            if (editName.text.isNotEmpty() && editEmail.text.isNotEmpty() && editPass.text.isNotEmpty() && editPass2.text.isNotEmpty()) {
                if (editPass.text.toString() == editPass2.text.toString()) {
                    FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(
                            editEmail.text.toString(),
                            editPass.text.toString()
                        ).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                showNewAccountAlert()
                            } else {
                                showAlert()
                            }
                        }
                } else {
                    // Show password mismatch alert
                    showPasswordMismatchAlert()
                }
            } else {
                // Show empty fields alert
                showEmptyFieldsAlert()
            }
        }
    }



// Other alert functions (showAlert, showPasswordMismatchAlert, showEmptyFieldsAlert)


    private fun showPasswordMismatchAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Password Mismatch")
        builder.setMessage("The entered passwords do not match.")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showEmptyFieldsAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Empty Fields")
        builder.setMessage("Please fill in all the fields.")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showNewAccountAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Account Created")
        builder.setMessage("Welcome!")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("An error occurred authenticating the user")
        builder.setPositiveButton("OK", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}