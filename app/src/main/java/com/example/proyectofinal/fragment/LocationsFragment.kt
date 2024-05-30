package com.example.proyectofinal.fragment

import android.content.Intent
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
import com.example.proyectofinal.activities.MapActivity

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
        val sucursalPlazaAndinaLatitud = 20.6715973
        val sucursalPlazaAndinaLongitud = -103.3429349


        locationList.add(
            Locations(
            sucursalPlazaAndinaName,
            sucursalPlazaAndinaDireccion,
            sucursalPlazaAndinaEstado,
            sucursalPlazaAndinaDistancia,
            sucursalPlazaAndinaLatitud,
            sucursalPlazaAndinaLongitud
        )
        )

        val sucursalBahiaGastronomicaName = getString(R.string.sucursal_bahia_gastronomica)
        val sucursalBahiaGastronomicaDireccion = getString(R.string.direccion_bahia_gastronomica)
        val sucursalBahiaGastronomicaEstado = getString(R.string.estado_bahia_gastronomica)
        val sucursalBahiaGastronomicaDistancia = getString(R.string.distancia_bahia_gastronomica)
        val sucursalBahiaGastronomicaLatitud = 23.2119469
        val sucursalBahiaGastronomicaLongitud = -106.4624959

        locationList.add(
            Locations(
            sucursalBahiaGastronomicaName,
            sucursalBahiaGastronomicaDireccion,
            sucursalBahiaGastronomicaEstado,
            sucursalBahiaGastronomicaDistancia,
            sucursalBahiaGastronomicaLatitud,
            sucursalBahiaGastronomicaLongitud
        )
         )

        val sucursalPuebloMediterraneoName = getString(R.string.sucursal_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoDireccion = getString(R.string.direccion_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoEstado = getString(R.string.estado_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoDistancia = getString(R.string.distancia_pueblo_mediterraneo)
        val sucursalPuebloMediterraneoLatitud = 26.2060774070761
        val sucursalPuebloMediterraneoLongitud = -80.507075838458

        locationList.add(
            Locations(
            sucursalPuebloMediterraneoName,
            sucursalPuebloMediterraneoDireccion,
            sucursalPuebloMediterraneoEstado,
            sucursalPuebloMediterraneoDistancia,
            sucursalPuebloMediterraneoLatitud,
            sucursalPuebloMediterraneoLongitud
        )
        )

        val sucursalCallejonToscanaName = getString(R.string.sucursal_callejon_toscana)
        val sucursalCallejonToscanaDireccion = getString(R.string.direccion_callejon_toscana)
        val sucursalCallejonToscanaEstado = getString(R.string.estado_callejon_toscana)
        val sucursalCallejonToscanaDistancia = getString(R.string.distancia_callejon_toscana)
        val sucursalCallejonToscanaLatitud = 20.5811682
        val sucursalCallejonToscanaLongitud = -103.3401961

        locationList.add(
            Locations(
            sucursalCallejonToscanaName,
            sucursalCallejonToscanaDireccion,
            sucursalCallejonToscanaEstado,
            sucursalCallejonToscanaDistancia,
            sucursalCallejonToscanaLatitud,
            sucursalCallejonToscanaLongitud
        )
        )

        val sucursalRinconcitoCaribenoName = getString(R.string.sucursal_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoDireccion = getString(R.string.direccion_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoEstado = getString(R.string.estado_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoDistancia = getString(R.string.distancia_rinconcito_caribeno)
        val sucursalRinconcitoCaribenoLatitud = 20.754419
        val sucursalRinconcitoCaribenoLongitud = -103.4182502

        locationList.add(
            Locations(
            sucursalRinconcitoCaribenoName,
            sucursalRinconcitoCaribenoDireccion,
            sucursalRinconcitoCaribenoEstado,
            sucursalRinconcitoCaribenoDistancia,
            sucursalRinconcitoCaribenoLatitud,
            sucursalRinconcitoCaribenoLongitud
        )
        )

        val sucursalAldeaOrientalName = getString(R.string.sucursal_aldea_oriental)
        val sucursalAldeaOrientalDireccion = getString(R.string.direccion_aldea_oriental)
        val sucursalAldeaOrientalEstado = getString(R.string.estado_aldea_oriental)
        val sucursalAldeaOrientalDistancia = getString(R.string.distancia_aldea_oriental)
        val sucursalAldeaOrientalLatitud = 16.4281517
        val sucursalAldeaOrientalLongitud = -89.958517

        locationList.add(
            Locations(
            sucursalAldeaOrientalName,
            sucursalAldeaOrientalDireccion,
            sucursalAldeaOrientalEstado,
            sucursalAldeaOrientalDistancia,
            sucursalAldeaOrientalLatitud,
            sucursalAldeaOrientalLongitud
        )
        )

        val sucursalAvenidaIbericaName = getString(R.string.sucursal_avenida_iberica)
        val sucursalAvenidaIbericaDireccion = getString(R.string.direccion_avenida_iberica)
        val sucursalAvenidaIbericaEstado = getString(R.string.estado_avenida_iberica)
        val sucursalAvenidaIbericaDistancia = getString(R.string.distancia_avenida_iberica)
        val sucursalAvenidaIbericaLatitud = 18.4639786
        val sucursalAvenidaIbericaLongitud= -84.5535278

        locationList.add(
            Locations(
            sucursalAvenidaIbericaName,
            sucursalAvenidaIbericaDireccion,
            sucursalAvenidaIbericaEstado,
            sucursalAvenidaIbericaDistancia,
            sucursalAvenidaIbericaLatitud,
            sucursalAvenidaIbericaLongitud
        )
        )

        val sucursalBarrioGastronomicoName = getString(R.string.sucursal_barrio_gastronomico)
        val sucursalBarrioGastronomicoDireccion = getString(R.string.direccion_barrio_gastronomico)
        val sucursalBarrioGastronomicoEstado = getString(R.string.estado_barrio_gastronomico)
        val sucursalBarrioGastronomicoDistancia = getString(R.string.distancia_barrio_gastronomico)
        val sucursalBarrioGastronomicoLatitud  =  -74.0060
        val sucursalBarrioGastronomicoLongitud = -32.55234

        locationList.add(
            Locations(
            sucursalBarrioGastronomicoName,
            sucursalBarrioGastronomicoDireccion,
            sucursalBarrioGastronomicoEstado,
            sucursalBarrioGastronomicoDistancia,
            sucursalBarrioGastronomicoLatitud,
            sucursalBarrioGastronomicoLongitud
        )
        )

        val sucursalCostaneraSaboresName = getString(R.string.sucursal_costanera_sabores)
        val sucursalCostaneraSaboresDireccion = getString(R.string.direccion_costanera_sabores)
        val sucursalCostaneraSaboresEstado = getString(R.string.estado_costanera_sabores)
        val sucursalCostaneraSaboresDistancia = getString(R.string.distancia_costanera_sabores)
        val sucursalCostaneraSaboresLatitud = 1213020.12312
        val sucursalCostaneraSaboresLongitud = 92384598.12394

        locationList.add(
            Locations(
            sucursalCostaneraSaboresName,
            sucursalCostaneraSaboresDireccion,
            sucursalCostaneraSaboresEstado,
            sucursalCostaneraSaboresDistancia,
            sucursalCostaneraSaboresLatitud,
            sucursalCostaneraSaboresLongitud
        )
        )

        val sucursalEsquinaBohemiaName = getString(R.string.sucursal_esquina_bohemia)
        val sucursalEsquinaBohemiaDireccion = getString(R.string.direccion_esquina_bohemia)
        val sucursalEsquinaBohemiaEstado = getString(R.string.estado_esquina_bohemia)
        val sucursalEsquinaBohemiaDistancia = getString(R.string.distancia_esquina_bohemia)
        val sucursalEsquinaBohemiaLatitud =  151.2093
        val sucursalEsquinaBohemiaLongitud = -74.0060

        locationList.add(
            Locations(
            sucursalEsquinaBohemiaName,
            sucursalEsquinaBohemiaDireccion,
            sucursalEsquinaBohemiaEstado,
            sucursalEsquinaBohemiaDistancia,
            sucursalEsquinaBohemiaLatitud,
            sucursalEsquinaBohemiaLongitud
        )
        )

        locationAdapter = LocationsAdapter(locationList)
        recyclerView.adapter = locationAdapter

        locationAdapter.onItemClick = { location ->
            // Crear un Intent para iniciar el nuevo Activity
            val intent = Intent(requireContext(), MapActivity::class.java)
            // Pasar cualquier dato necesario al nuevo Activity
            intent.putExtra("locationName", location.address)
            intent.putExtra("latitud", location.latitude)
            intent.putExtra("longitud", location.longitude)
            // Iniciar el nuevo Activity
            startActivity(intent)
        }

        return view
    }
}