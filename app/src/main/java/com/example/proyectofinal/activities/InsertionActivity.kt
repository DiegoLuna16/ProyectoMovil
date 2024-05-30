package com.example.proyectofinal.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import com.example.proyectofinal.models.EmployeeModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.FlowPreview
import java.util.UUID

class InsertionActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPosition: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnSelectImage: Button
    private lateinit var ivPreview: ImageView

    private lateinit var dbRef: DatabaseReference
    private lateinit var storageRef: StorageReference
    private var imageUrl: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etEmail = findViewById(R.id.etEmail)
        etPosition = findViewById(R.id.etPosition)
        etAddress = findViewById(R.id.etAddress)
        btnGuardar = findViewById(R.id.btnSave)
        btnSelectImage = findViewById(R.id.btnSelectImage)
        ivPreview = findViewById(R.id.ivPreview)

        dbRef = FirebaseDatabase.getInstance().getReference("Empleados")
        storageRef = FirebaseStorage.getInstance().reference.child("images")

        btnSelectImage.setOnClickListener {
            selectImage()
        }

        btnGuardar.setOnClickListener {
            saveData()
        }
    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            imageUrl = data.data
            ivPreview.setImageURI(imageUrl)
        }
    }

    private fun saveData() {
        val name = etName.text.toString()
        val age = etAge.text.toString()
        val email = etEmail.text.toString()
        val position = etPosition.text.toString()
        val address = etAddress.text.toString()

        if (name.isEmpty() || age.isEmpty() || email.isEmpty() || position.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (imageUrl == null) {
            Toast.makeText(this, "Por favor, seleccione una imagen", Toast.LENGTH_SHORT).show()
            return
        }

        val id = dbRef.push().key!!
        val imageRef = storageRef.child("images/${UUID.randomUUID()}.jpg")

        imageRef.putFile(imageUrl!!)
            .addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    val embarque =
                        EmployeeModel(id, name, age, email, position, address, uri.toString())
                    dbRef.child(id).setValue(embarque)
                        .addOnCompleteListener {
                            Toast.makeText(this, "Datos insertados con éxito", Toast.LENGTH_LONG)
                                .show()
                            clearData()
                        }
                        .addOnFailureListener { err ->
                            Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
            .addOnFailureListener { err ->
                Toast.makeText(this, "Error al subir la imagen: ${err.message}", Toast.LENGTH_LONG)
                    .show()
            }
    }


    private fun clearData() {
        etName.setText("")
        etAge.setText("")
        etEmail.setText("")
        etPosition.setText("")
        etAddress.setText("")
        ivPreview.setImageURI(null)
    }

}