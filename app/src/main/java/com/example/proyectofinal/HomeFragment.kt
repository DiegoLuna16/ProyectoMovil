package com.example.proyectofinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_news -> {
                    replaceFragment(NewsFragment())
                }
                R.id.nav_coupons ->{
                    replaceFragment(CouponsFragment())
                }
                R.id.nav_delivery ->{
                    replaceFragment(DeliveryFragment())
                }
                R.id.nav_locations ->{
                    replaceFragment(LocationsFragment())
                }
            }
            true
        }

        replaceFragment(NewsFragment())
        bottomNavigationView.selectedItemId = R.id.nav_news
        return view
    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment,fragment)
            .commit()
    }
}