package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()
    }

    private fun setup(){

        val btnSignUp : Button = findViewById(R.id.btnSignUp)
        val btnLogIn : Button = findViewById(R.id.btnLogin)
        val editEmail : EditText = findViewById(R.id.editEmail)
        val editPass : EditText = findViewById(R.id.editPass)

        title = "Login"

        btnSignUp.setOnClickListener{
            if (editEmail.text.isNotEmpty() && editPass.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(editEmail.text.toString(),
                        editPass.text.toString()).addOnCompleteListener {
                            if (it.isSuccessful){
                                showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                            } else {
                                showAlert()
                            }
                    }
            }
        }

        btnLogIn.setOnClickListener{
            if (editEmail.text.isNotEmpty() && editPass.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(editEmail.text.toString(),
                        editPass.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }

    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("An error occurred authenticating the user")
        builder.setPositiveButton("Accept", null)
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String,provider : ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply{
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }
}