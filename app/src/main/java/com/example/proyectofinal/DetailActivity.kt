package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val foodName = intent.getStringExtra("food1")
        val foodDescription = intent.getStringExtra("food2")
        val foodPrice = intent.getStringExtra("food3")
        val foodImage = intent.getIntExtra("foodImage", 0) // Asegúrate de pasar la imagen también

        val textViewTitle = findViewById<TextView>(R.id.textViewTitleDetail)
        val textViewDescription = findViewById<TextView>(R.id.textViewDesDetail)
        val textViewPrice = findViewById<TextView>(R.id.textViewPriceDetail)
        val imageView = findViewById<ImageView>(R.id.imageViewDetail)



        textViewTitle.text = foodName
        textViewDescription.text = foodDescription
        textViewPrice.text = foodPrice
        imageView.setImageResource(foodImage)

        val btnGoBack = findViewById<Button>(R.id.btnGoBack)
        btnGoBack.setOnClickListener {
            onBackPressed()
        }
    }
}