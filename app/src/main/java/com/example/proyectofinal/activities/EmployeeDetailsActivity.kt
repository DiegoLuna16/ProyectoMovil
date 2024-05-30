package com.example.proyectofinal.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.proyectofinal.R
import com.example.proyectofinal.models.EmployeeModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class EmployeeDetailsActivity : AppCompatActivity() {

    private lateinit var tvId: TextView
    private lateinit var tvName: TextView
    private lateinit var tvAge : TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPosition : TextView
    private lateinit var tvAddress : TextView

    private lateinit var ivEmbImage: ImageView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var btnUpdateImage: Button

    private var imageUri: Uri? = null
    private lateinit var storageRef: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        storageRef = FirebaseStorage.getInstance().reference.child("images")

        initView()
        setValuesToViews()

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("empId").toString(),
                intent.getStringExtra("empName").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("empId").toString()
            )
        }

        btnUpdateImage.setOnClickListener {
            selectImage()
        }
    }

    private fun deleteRecord(id: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Empleados").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(applicationContext, "Empleado eliminado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, FetchActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener { error ->
            Toast.makeText(applicationContext, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun openUpdateDialog(
        empId: String,
        empName: String

    ) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_dialog, null)

        mDialog.setView(mDialogView)

        val etName = mDialogView.findViewById<EditText>(R.id.etName)
        val etAge = mDialogView.findViewById<EditText>(R.id.etAge)
        val etEmail = mDialogView.findViewById<EditText>(R.id.etEmail)
        val etPosition = mDialogView.findViewById<EditText>(R.id.etPosition)
        val etAddress = mDialogView.findViewById<EditText>(R.id.etAddress)
        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etName.setText(intent.getStringExtra("empName").toString())
        etAge.setText(intent.getStringExtra("empAge").toString())
        etEmail.setText(intent.getStringExtra("empEmail").toString())
        etPosition.setText(intent.getStringExtra("empPosition").toString())
        etAddress.setText(intent.getStringExtra("empAddress").toString())


        mDialog.setTitle("Actualizando $empName")
        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateEmbData(
                empId,
                etName.text.toString(),
                etAge.text.toString(),
                etEmail.text.toString(),
                etPosition.text.toString(),
                etAddress.text.toString()
            )
            Toast.makeText(applicationContext, "Empleado Actualizado", Toast.LENGTH_LONG).show()

            tvName.text = etName.text.toString()
            tvAge.text = etAge.text.toString()
            tvEmail.text = etEmail.text.toString()
            tvPosition.text = etPosition.text.toString()
            tvAddress.text = etAddress.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateEmbData(id: String, name: String, age: String, email: String,position: String, address: String) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Empleados").child(id)
        val embInfo = EmployeeModel(id, name, age, email,position,address, intent.getStringExtra("empImageUrl").toString())
        dbRef.setValue(embInfo)
    }

    private fun initView() {
        tvId = findViewById(R.id.tvId)
        tvName = findViewById(R.id.tvName)
        tvAge = findViewById(R.id.tvAge)
        tvEmail = findViewById(R.id.tvEmail)
        tvPosition = findViewById(R.id.tvPosition)
        tvAddress = findViewById(R.id.tvAddress)
        ivEmbImage = findViewById(R.id.ivEmbImage)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        btnUpdateImage = findViewById(R.id.btnUpdateImage)
    }

    private fun setValuesToViews() {
        tvId.text = intent.getStringExtra("empId")
        tvName.text = intent.getStringExtra("empName")
        tvAge.text = intent.getStringExtra("empAge")
        tvEmail.text = intent.getStringExtra("empEmail")
        tvPosition.text = intent.getStringExtra("empPosition")
        tvAddress.text = intent.getStringExtra("empAddress")


        // Cargar la imagen con Glide
        val imageUrl = intent.getStringExtra("empImageUrl")
        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .into(ivEmbImage)
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
            imageUri = data.data
            ivEmbImage.setImageURI(imageUri)
            uploadImage()
        }
    }

    private fun uploadImage() {
        if (imageUri != null) {
            val imageRef = storageRef.child("images/${UUID.randomUUID()}.jpg")
            imageRef.putFile(imageUri!!)
                .addOnSuccessListener {
                    imageRef.downloadUrl.addOnSuccessListener { uri ->
                        val imageUrl = uri.toString()
                        updateImageInDatabase(imageUrl)
                    }
                }
                .addOnFailureListener { err ->
                    Toast.makeText(this, "Error al subir la imagen: ${err.message}", Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun updateImageInDatabase(imageUrl: String) {
        val embId = intent.getStringExtra("empId").toString()
        val dbRef = FirebaseDatabase.getInstance().getReference("Empleados").child(embId)
        dbRef.child("imageUrl").setValue(imageUrl)
            .addOnSuccessListener {
                Toast.makeText(this, "Imagen actualizada correctamente", Toast.LENGTH_SHORT).show()
                Glide.with(this).load(imageUrl).into(ivEmbImage)
            }
            .addOnFailureListener { err ->
                Toast.makeText(this, "Error al actualizar la imagen: ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}
