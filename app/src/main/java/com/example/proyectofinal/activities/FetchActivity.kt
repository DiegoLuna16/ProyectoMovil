package com.example.proyectofinal.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.adapters.EmployeeAdapter
import com.example.proyectofinal.models.EmployeeModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FetchActivity : AppCompatActivity() {

    private lateinit var embRecyclerView : RecyclerView
    private lateinit var tvDatos: TextView
    private lateinit var embList: ArrayList<EmployeeModel>
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)

        embRecyclerView = findViewById(R.id.rvEmployee)
        embRecyclerView.layoutManager = LinearLayoutManager(this)
        embRecyclerView.setHasFixedSize(true)
        tvDatos = findViewById(R.id.tvDatos)

        embList = arrayListOf<EmployeeModel>()

        getEmbarqueData()

    }

    private fun getEmbarqueData(){
        embRecyclerView.visibility = View.GONE
        tvDatos.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Empleados")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                embList.clear()
                if (snapshot.exists()){
                    for (embSnap in snapshot.children){
                        val embData = embSnap.getValue(EmployeeModel::class.java)
                        embList.add(embData!!)
                    }
                    val mAdapter = EmployeeAdapter(embList)
                    embRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : EmployeeAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchActivity, EmployeeDetailsActivity::class.java)

                            //put extras

                            intent.putExtra("empId",embList[position].id)
                            intent.putExtra("empName",embList[position].name)
                            intent.putExtra("empAge",embList[position].age)
                            intent.putExtra("empEmail",embList[position].email)
                            intent.putExtra("empPosition",embList[position].position)
                            intent.putExtra("empAddress",embList[position].address)
                            intent.putExtra("empImageUrl", embList[position].imageUrl)

                            startActivity(intent)

                        }

                    })

                    embRecyclerView.visibility = View.VISIBLE
                    tvDatos.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}