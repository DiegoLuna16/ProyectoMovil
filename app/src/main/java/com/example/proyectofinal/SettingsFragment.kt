package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner

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

        name = arguments?.getString("name")
        email = arguments?.getString("email")
        password = arguments?.getString("password")
        phone = arguments?.getString("phone")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup(name ?: "", email ?: "", password ?: "", phone ?: "", view)
    }

    private fun setup(name: String, email: String, password: String, phone: String, view: View) {
        val editName: TextView = view.findViewById(R.id.textName)
        val editEmail: TextView = view.findViewById(R.id.textEmail)
        val editPassword: TextView = view.findViewById(R.id.textPass)
        val editPhone: TextView = view.findViewById(R.id.textPhone)

        editName.text = "Name: $name"
        editEmail.text = "Email: $email"
        editPassword.text = "Password: $password"
        editPhone.text = "Phone: $phone"
    }
}

