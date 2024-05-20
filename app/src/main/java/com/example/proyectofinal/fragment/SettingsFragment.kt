package com.example.proyectofinal.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.proyectofinal.R
import com.example.proyectofinal.activites.ReservationActivity

class SettingsFragment : Fragment() {
    private var name: String? = null
    private var email: String? = null
    private var password: String? = null
    private var phone: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val btnBook  = view.findViewById<Button>(R.id.btnReservation)

        btnBook.setOnClickListener {
            val intent = Intent(requireContext(), ReservationActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}

