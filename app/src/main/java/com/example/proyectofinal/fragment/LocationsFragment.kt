package com.example.proyectofinal.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.models.Locations
import com.example.proyectofinal.adapters.LocationsAdapter
import com.example.proyectofinal.R

class LocationsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var locationList: ArrayList<Locations>
    private lateinit var locationAdapter: LocationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_locations, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewLocation)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager
        locationList = ArrayList()

        val sucursalPlazaAndinaName = getString(R.string.sucursal_plaza_andina)
        val sucursalPlazaAndinaEstado = getString(R.string.estado_plaza_andina)
        val sucursalPlazaAndinaDireccion = getString(R.string.direccion_plaza_andina)
        val sucursalPlazaAndinaDistancia = getString(R.string.distancia_plaza_andina)

        locationList.add(
            Locations(
            sucursalPlazaAndinaName,
            sucursalPlazaAndinaDireccion,
            sucursalPlazaAndinaEstado,
            sucursalPlazaAndinaDistancia
        )
        )

        val sucursalBahiaGastronomicaName = getString(R.string.sucursal_bahia_gastronomica)
        val sucursalBahiaGastronomicaDireccion = getString(R.string.direccion_bahia_gastronomica)
        val sucursalBahiaGastronomicaEstado = getString(R.string.estado_bahia_gastronomica)
        val sucursalBahiaGastronomicaDistancia = getString(R.string.distancia_bahia_gastronomica)

        locationList.add(
            Locations(
            sucursalBahiaGastronomicaName,
            sucursalBahiaGastronomicaDireccion,
            sucursalBahiaGastronomicaEstado,
            sucursalBahiaGastronomicaDistancia
        )
        )

        val sucursalPuebloMediterraneoName = getString(R.string.sucursal_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoDireccion = getString(R.string.direccion_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoEstado = getString(R.string.estado_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoDistancia = getString(R.string.distancia_pueblo_mediterraneo)

        locationList.add(
            Locations(
            sucursalPuebloMediterraneoName,
            sucursalPuebloMediterraneoDireccion,
            sucursalPuebloMediterraneoEstado,
            sucursalPuebloMediterraneoDistancia
        )
        )

        val sucursalCallejonToscanaName = getString(R.string.sucursal_callejon_toscana)
        val sucursalCallejonToscanaDireccion = getString(R.string.direccion_callejon_toscana)
        val sucursalCallejonToscanaEstado = getString(R.string.estado_callejon_toscana)
        val sucursalCallejonToscanaDistancia = getString(R.string.distancia_callejon_toscana)

        locationList.add(
            Locations(
            sucursalCallejonToscanaName,
            sucursalCallejonToscanaDireccion,
            sucursalCallejonToscanaEstado,
            sucursalCallejonToscanaDistancia
        )
        )

        val sucursalRinconcitoCaribenoName = getString(R.string.sucursal_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoDireccion = getString(R.string.direccion_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoEstado = getString(R.string.estado_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoDistancia = getString(R.string.distancia_rinconcito_caribeno)

        locationList.add(
            Locations(
            sucursalRinconcitoCaribenoName,
            sucursalRinconcitoCaribenoDireccion,
            sucursalRinconcitoCaribenoEstado,
            sucursalRinconcitoCaribenoDistancia
        )
        )

        val sucursalAldeaOrientalName = getString(R.string.sucursal_aldea_oriental)
        val sucursalAldeaOrientalDireccion = getString(R.string.direccion_aldea_oriental)
        val sucursalAldeaOrientalEstado = getString(R.string.estado_aldea_oriental)
        val sucursalAldeaOrientalDistancia = getString(R.string.distancia_aldea_oriental)

        locationList.add(
            Locations(
            sucursalAldeaOrientalName,
            sucursalAldeaOrientalDireccion,
            sucursalAldeaOrientalEstado,
            sucursalAldeaOrientalDistancia
        )
        )

        val sucursalAvenidaIbericaName = getString(R.string.sucursal_avenida_iberica)
        val sucursalAvenidaIbericaDireccion = getString(R.string.direccion_avenida_iberica)
        val sucursalAvenidaIbericaEstado = getString(R.string.estado_avenida_iberica)
        val sucursalAvenidaIbericaDistancia = getString(R.string.distancia_avenida_iberica)

        locationList.add(
            Locations(
            sucursalAvenidaIbericaName,
            sucursalAvenidaIbericaDireccion,
            sucursalAvenidaIbericaEstado,
            sucursalAvenidaIbericaDistancia
        )
        )

        val sucursalBarrioGastronomicoName = getString(R.string.sucursal_barrio_gastronomico)
        val sucursalBarrioGastronomicoDireccion = getString(R.string.direccion_barrio_gastronomico)
        val sucursalBarrioGastronomicoEstado = getString(R.string.estado_barrio_gastronomico)
        val sucursalBarrioGastronomicoDistancia = getString(R.string.distancia_barrio_gastronomico)

        locationList.add(
            Locations(
            sucursalBarrioGastronomicoName,
            sucursalBarrioGastronomicoDireccion,
            sucursalBarrioGastronomicoEstado,
            sucursalBarrioGastronomicoDistancia
        )
        )

        val sucursalCostaneraSaboresName = getString(R.string.sucursal_costanera_sabores)
        val sucursalCostaneraSaboresDireccion = getString(R.string.direccion_costanera_sabores)
        val sucursalCostaneraSaboresEstado = getString(R.string.estado_costanera_sabores)
        val sucursalCostaneraSaboresDistancia = getString(R.string.distancia_costanera_sabores)

        locationList.add(
            Locations(
            sucursalCostaneraSaboresName,
            sucursalCostaneraSaboresDireccion,
            sucursalCostaneraSaboresEstado,
            sucursalCostaneraSaboresDistancia
        )
        )

        val sucursalEsquinaBohemiaName = getString(R.string.sucursal_esquina_bohemia)
        val sucursalEsquinaBohemiaDireccion = getString(R.string.direccion_esquina_bohemia)
        val sucursalEsquinaBohemiaEstado = getString(R.string.estado_esquina_bohemia)
        val sucursalEsquinaBohemiaDistancia = getString(R.string.distancia_esquina_bohemia)

        locationList.add(
            Locations(
            sucursalEsquinaBohemiaName,
            sucursalEsquinaBohemiaDireccion,
            sucursalEsquinaBohemiaEstado,
            sucursalEsquinaBohemiaDistancia
        )
        )

        locationAdapter = LocationsAdapter(locationList)
        recyclerView.adapter = locationAdapter

        locationAdapter.onItemClick = {
            
        }

        return view
    }
}