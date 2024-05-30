package com.example.proyectofinal.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R
import com.google.android.material.button.MaterialButton
import java.util.Calendar

class ReservationActivity : AppCompatActivity() {
    val selectedCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val scheduledDate = findViewById<EditText>(R.id.editDay)

        scheduledDate.setOnClickListener {
            onDateSelected(it)
        }

        val scheduledTime = findViewById<EditText>(R.id.editTime)

        scheduledTime.setOnClickListener {
            onTimeSelected(it)
        }


        val mesa = resources.getStringArray(R.array.mesasArray)
        val mesaAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesa)
        val spinner: Spinner = findViewById(R.id.spinner)
        spinner.adapter = mesaAdapter

        val sucursal = resources.getStringArray(R.array.sucursalesArray)
        val sucursalAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sucursal)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        spinner2.adapter = sucursalAdapter

        val btnReservar = findViewById<MaterialButton>(R.id.btnReser)

        btnReservar.setOnClickListener{
            val editName = findViewById<EditText>(R.id.editName)
            val editTime = findViewById<EditText>(R.id.editTime)
            val editDay = findViewById<EditText>(R.id.editDay)
            val name = editName.text.toString()
            val time = editTime.text.toString()
            val day = editDay.text.toString()
            showConfirmation(name,day,time)
        }

    }

    private fun onDateSelected(v: View?) {
        val scheduledDate = findViewById<EditText>(R.id.editDay)
        val selectedCalendar = Calendar.getInstance()

        val year = selectedCalendar.get(Calendar.YEAR)
        val month = selectedCalendar.get(Calendar.MONTH)
        val day = selectedCalendar.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
            selectedCalendar.set(y, m, d)
            val adjustedMonth = m +1
            scheduledDate.setText("$y-$adjustedMonth-$d")
        }

        DatePickerDialog(this, listener, year, month, day).show()
    }

    private fun onTimeSelected(v: View?) {
        val scheduledTime = findViewById<EditText>(R.id.editTime)
        val selectedCalendar = Calendar.getInstance()

        val hourOfDay = selectedCalendar.get(Calendar.HOUR_OF_DAY) // Hora actual en formato de 24 horas
        val minute = selectedCalendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, hour, min ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY, hour)
            selectedTime.set(Calendar.MINUTE, min)

            val validStartTime = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 13) // Hora de inicio permitida
                set(Calendar.MINUTE, 0)
            }

            val validEndTime = Calendar.getInstance().apply {
                set(Calendar.HOUR_OF_DAY, 22) // Hora de fin permitida
                set(Calendar.MINUTE, 0)
            }

            // Verificar si la hora seleccionada está dentro del rango permitido
            if (selectedTime in validStartTime..validEndTime) {
                val formattedTime = String.format("%02d:%02d", hour, min)
                scheduledTime.setText(formattedTime)
            } else {
                // Hora seleccionada fuera del rango permitido, mostrar mensaje o tomar alguna acción
                Toast.makeText(
                    this,
                    "Por favor selecciona una hora entre 13:00 y 22:00",
                    Toast.LENGTH_SHORT
                ).show()
                // También podrías reiniciar la selección o tomar otra acción según tu flujo
            }
        }, hourOfDay, minute, true) // true para usar formato de 24 horas

        timePickerDialog.show()
    }


    private fun showConfirmation(name: String,day: String, time : String) {
        val mainIntent = Intent(this, MyReservationsActivity::class.java).apply {
            putExtra("name", name)
            putExtra("day", day)
            putExtra("time", time)
        }
        startActivity(mainIntent)
    }

}