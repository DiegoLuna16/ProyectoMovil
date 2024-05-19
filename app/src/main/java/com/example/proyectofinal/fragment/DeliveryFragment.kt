package com.example.proyectofinal.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.activies.DetailActivity
import com.example.proyectofinal.models.Food
import com.example.proyectofinal.adapters.FoodAdapter
import com.example.proyectofinal.R

class DeliveryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delivery, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewFood)
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager
        foodList = ArrayList()

        val ordenFlautasImage = R.drawable.orden_flautas
        val ordenFlautasName = getString(R.string.orden_flautas)
        val ordenFlautasDesc = getString(R.string.orden_flautas_des)
        val ordenFlautasPrice = getString(R.string.orden_flautas_price)

        foodList.add(Food(ordenFlautasImage, ordenFlautasName, ordenFlautasDesc, ordenFlautasPrice))

        val nuggetsImage = R.drawable.nuggets
        val nuggetsName = getString(R.string.nuggets)
        val nuggetsDesc = getString(R.string.nuggets_des)
        val nuggetsPrice = getString(R.string.nuggets_price)

        foodList.add(Food(nuggetsImage, nuggetsName, nuggetsDesc, nuggetsPrice))

        val piezas2Image = R.drawable.piezas2
        val piezas2Name = getString(R.string.dos_piezas_pollo)
        val piezas2Desc = getString(R.string.dos_piezas_pollo_des)
        val piezas2Price = getString(R.string.dos_piezas_pollo_price)

        foodList.add(Food(piezas2Image, piezas2Name, piezas2Desc, piezas2Price))

        val piezas3Image = R.drawable.piezas3
        val piezas3Name = getString(R.string.tres_piezas_pollo)
        val piezas3Desc = getString(R.string.tres_piezas_pollo_des)
        val piezas3Price = getString(R.string.tres_piezas_pollo_price)

        foodList.add(Food(piezas3Image, piezas3Name, piezas3Desc, piezas3Price))

        val piezas5Image = R.drawable.piezas5
        val piezas5Name = getString(R.string.cinco_piezas_pollo)
        val piezas5Desc = getString(R.string.cinco_piezas_pollo_des)
        val piezas5Price = getString(R.string.cinco_piezas_pollo_price)

        foodList.add(Food(piezas5Image, piezas5Name, piezas5Desc, piezas5Price))

        val piezas7Image = R.drawable.piezas7
        val piezas7Name = getString(R.string.siete_piezas_pollo)
        val piezas7Desc = getString(R.string.siete_piezas_pollo_des)
        val piezas7Price = getString(R.string.siete_piezas_pollo_price)

        foodList.add(Food(piezas7Image, piezas7Name, piezas7Desc, piezas7Price))

        val piezas10Image = R.drawable.piezas10
        val piezas10Name = getString(R.string.diez_piezas_pollo)
        val piezas10Desc = getString(R.string.diez_piezas_pollo_des)
        val piezas10Price = getString(R.string.diez_piezas_pollo_price)

        foodList.add(Food(piezas10Image, piezas10Name, piezas10Desc, piezas10Price))

        val piezas12Image = R.drawable.piezas12
        val piezas12Name = getString(R.string.doce_piezas_pollo)
        val piezas12Desc = getString(R.string.doce_piezas_pollo_des)
        val piezas12Price = getString(R.string.doce_piezas_pollo_price)

        foodList.add(Food(piezas12Image, piezas12Name, piezas12Desc, piezas12Price))

        val piezas15Image = R.drawable.piezas15
        val piezas15Name = getString(R.string.quince_piezas_pollo)
        val piezas15Desc = getString(R.string.quince_piezas_pollo_des)
        val piezas15Price = getString(R.string.quince_piezas_pollo_price)

        foodList.add(Food(piezas15Image, piezas15Name, piezas15Desc, piezas15Price))

        val paquete7Image = R.drawable.paquete_7piezas
        val paquete7Name = getString(R.string.paquete_siete_piezas)
        val paquete7Desc = getString(R.string.paquete_siete_piezas_des)
        val paquete7Price = getString(R.string.paquete_siete_piezas_price)

        foodList.add(Food(paquete7Image, paquete7Name, paquete7Desc, paquete7Price))

        val paquete10Image = R.drawable.paquete_10piezas
        val paquete10Name = getString(R.string.paquete_diez_piezas)
        val paquete10Desc = getString(R.string.paquete_diez_piezas_des)
        val paquete10Price = getString(R.string.paquete_diez_piezas_price)

        foodList.add(Food(paquete10Image, paquete10Name, paquete10Desc, paquete10Price))

        val paquete15Image = R.drawable.paquete_15piezas
        val paquete15Name = getString(R.string.paquete_quince_piezas)
        val paquete15Desc = getString(R.string.paquete_quince_piezas_des)
        val paquete15Price = getString(R.string.paquete_quince_piezas_price)

        foodList.add(Food(paquete15Image, paquete15Name, paquete15Desc, paquete15Price))

        val hamResImage = R.drawable.ham_res
        val hamResName = getString(R.string.combo_hamburguesa_res)
        val hamResDesc = getString(R.string.combo_hamburguesa_res_des)
        val hamResPrice = getString(R.string.combo_hamburguesa_res_price)

        foodList.add(Food(hamResImage, hamResName, hamResDesc, hamResPrice))

        val hamPolloImage = R.drawable.ham_pollo
        val hamPolloName = getString(R.string.combo_hamburguesa_pollo)
        val hamPolloDesc = getString(R.string.combo_hamburguesa_pollo_des)
        val hamPolloPrice = getString(R.string.combo_hamburguesa_pollo_price)

        foodList.add(Food(hamPolloImage, hamPolloName, hamPolloDesc, hamPolloPrice))

        val ensCesarImage = R.drawable.ens_cesar
        val ensCesarName = getString(R.string.ensalada_cesar_con_pollo)
        val ensCesarDesc = getString(R.string.ensalada_cesar_con_pollo_des)
        val ensCesarPrice = getString(R.string.ensalada_cesar_con_pollo_price)

        foodList.add(Food(ensCesarImage, ensCesarName, ensCesarDesc, ensCesarPrice))

        val ensChefImage = R.drawable.ens_chef
        val ensChefName = getString(R.string.ensalada_chef_con_pollo)
        val ensChefDesc = getString(R.string.ensalada_chef_con_pollo_des)
        val ensChefPrice = getString(R.string.ensalada_chef_con_pollo_price)

        foodList.add(Food(ensChefImage, ensChefName, ensChefDesc, ensChefPrice))

        val tacosUnoImage = R.drawable.tacos
        val tacosUnoName = getString(R.string.tacos_pollo_uno)
        val tacosUnoDesc = getString(R.string.tacos_pollo_uno_des)
        val tacosUnoPrice = getString(R.string.tacos_pollo_uno_price)

        foodList.add(Food(tacosUnoImage, tacosUnoName, tacosUnoDesc, tacosUnoPrice))

        val tacosCincoImage = R.drawable.tacos
        val tacosCincoName = getString(R.string.tacos_pollo_cinco)
        val tacosCincoDesc = getString(R.string.tacos_pollo_cinco_des)
        val tacosCincoPrice = getString(R.string.tacos_pollo_cinco_price)

        foodList.add(Food(tacosCincoImage, tacosCincoName, tacosCincoDesc, tacosCincoPrice))

        val tacosDiezImage = R.drawable.tacos
        val tacosDiezName = getString(R.string.tacos_pollo_diez)
        val tacosDiezDesc = getString(R.string.tacos_pollo_diez_des)
        val tacosDiezPrice = getString(R.string.tacos_pollo_diez_price)

        foodList.add(Food(tacosDiezImage, tacosDiezName, tacosDiezDesc, tacosDiezPrice))

        val colTradicionalImage = R.drawable.col_tradicional
        val colTradicionalName = getString(R.string.col_tradicional)
        val colTradicionalDesc = getString(R.string.col_tradicional_des)
        val colTradicionalPrice = getString(R.string.col_tradicional_price)

        foodList.add(Food(colTradicionalImage, colTradicionalName, colTradicionalDesc, colTradicionalPrice))

        val sopaArrozImage = R.drawable.sopa_arroz
        val sopaArrozName = getString(R.string.sopa_arroz)
        val sopaArrozDesc = getString(R.string.sopa_arroz_des)
        val sopaArrozPrice = getString(R.string.sopa_arroz_price)

        foodList.add(Food(sopaArrozImage, sopaArrozName, sopaArrozDesc, sopaArrozPrice))

        val frijolesCharrosImage = R.drawable.frijoles_charros
        val frijolesCharrosName = getString(R.string.frijoles_charros)
        val frijolesCharrosDesc = getString(R.string.frijoles_charros_des)
        val frijolesCharrosPrice = getString(R.string.frijoles_charros_price)

        foodList.add(Food(frijolesCharrosImage, frijolesCharrosName, frijolesCharrosDesc, frijolesCharrosPrice))

        val purePapaImage = R.drawable.pure_papa
        val purePapaName = getString(R.string.pure_papa)
        val purePapaDesc = getString(R.string.pure_papa_des)
        val purePapaPrice = getString(R.string.pure_papa_price)

        foodList.add(Food(purePapaImage, purePapaName, purePapaDesc, purePapaPrice))

        val ensCoditoImage = R.drawable.ens_codito
        val ensCoditoName = getString(R.string.ensalada_codito)
        val ensCoditoDesc = getString(R.string.ensalada_codito_des)
        val ensCoditoPrice = getString(R.string.ensalada_codito_price)

        foodList.add(Food(ensCoditoImage, ensCoditoName, ensCoditoDesc, ensCoditoPrice))

        val ensFrescaImage = R.drawable.ens_fresca
        val ensFrescaName = getString(R.string.ensalada_fresca)
        val ensFrescaDesc = getString(R.string.ensalada_fresca_des)
        val ensFrescaPrice = getString(R.string.ensalada_fresca_price)

        foodList.add(Food(ensFrescaImage, ensFrescaName, ensFrescaDesc, ensFrescaPrice))

        val papasFrancesaImage = R.drawable.papas_francesa
        val papasFrancesaName = getString(R.string.papas_francesa)
        val papasFrancesaDesc = getString(R.string.papas_francesa_des)
        val papasFrancesaPrice = getString(R.string.papas_francesa_price)

        foodList.add(Food(papasFrancesaImage, papasFrancesaName, papasFrancesaDesc, papasFrancesaPrice))

        val flanNapolitanoImage = R.drawable.flan
        val flanNapolitanoName = getString(R.string.flan_napolitano)
        val flanNapolitanoDesc = getString(R.string.flan_napolitano_des)
        val flanNapolitanoPrice = getString(R.string.flan_napolitano_price)

        foodList.add(Food(flanNapolitanoImage, flanNapolitanoName, flanNapolitanoDesc, flanNapolitanoPrice))

        val payQuesoImage = R.drawable.pay_queso
        val payQuesoName = getString(R.string.pay_queso)
        val payQuesoDesc = getString(R.string.pay_queso_des)
        val payQuesoPrice = getString(R.string.pay_queso_price)

        foodList.add(Food(payQuesoImage, payQuesoName, payQuesoDesc, payQuesoPrice))

        val payManzanaImage = R.drawable.pay_manzana
        val payManzanaName = getString(R.string.pay_manzana)
        val payManzanaDesc = getString(R.string.pay_manzana_des)
        val payManzanaPrice = getString(R.string.pay_manzana_price)

        foodList.add(Food(payManzanaImage, payManzanaName, payManzanaDesc, payManzanaPrice))

        val cielNaturalImage = R.drawable.ciel
        val cielNaturalName = getString(R.string.ciel_natural)
        val cielNaturalDesc = getString(R.string.ciel_natural_des)
        val cielNaturalPrice = getString(R.string.ciel_natural_price)

        foodList.add(Food(cielNaturalImage, cielNaturalName, cielNaturalDesc, cielNaturalPrice))

        val aguaHorchataImage = R.drawable.horchata
        val aguaHorchataName = getString(R.string.agua_horchata)
        val aguaHorchataDesc = getString(R.string.agua_horchata_des)
        val aguaHorchataPrice = getString(R.string.agua_horchata_price)

        foodList.add(Food(aguaHorchataImage, aguaHorchataName, aguaHorchataDesc, aguaHorchataPrice))

        val aguaJamaicaImage = R.drawable.jamaica
        val aguaJamaicaName = getString(R.string.agua_jamaica)
        val aguaJamaicaDesc = getString(R.string.agua_jamaica_des)
        val aguaJamaicaPrice = getString(R.string.agua_jamaica_price)

        foodList.add(Food(aguaJamaicaImage, aguaJamaicaName, aguaJamaicaDesc, aguaJamaicaPrice))

        val aguaTamarindoImage = R.drawable.tamarindo
        val aguaTamarindoName = getString(R.string.agua_tamarindo)
        val aguaTamarindoDesc = getString(R.string.agua_tamarindo_des)
        val aguaTamarindoPrice = getString(R.string.agua_tamarindo_price)

        foodList.add(Food(aguaTamarindoImage, aguaTamarindoName, aguaTamarindoDesc, aguaTamarindoPrice))

        val cocaColaImage = R.drawable.coca
        val cocaColaName = getString(R.string.coca_cola_original)
        val cocaColaDesc = getString(R.string.coca_cola_original_des)
        val cocaColaPrice = getString(R.string.coca_cola_original_price)

        foodList.add(Food(cocaColaImage, cocaColaName, cocaColaDesc, cocaColaPrice))

        val sidralMundetImage = R.drawable.sidral
        val sidralMundetName = getString(R.string.sidral_mundet)
        val sidralMundetDesc = getString(R.string.sidral_mundet_des)
        val sidralMundetPrice = getString(R.string.sidral_mundet_price)

        foodList.add(Food(sidralMundetImage, sidralMundetName, sidralMundetDesc, sidralMundetPrice))

        val spriteImage = R.drawable.sprite
        val spriteName = getString(R.string.sprite)
        val spriteDesc = getString(R.string.sprite_des)
        val spritePrice = getString(R.string.sprite_price)

        foodList.add(Food(spriteImage, spriteName, spriteDesc, spritePrice))

        val pelucheImage = R.drawable.peluche
        val pelucheName = getString(R.string.pepeluche)
        val pelucheDesc = getString(R.string.pepeluche_des)
        val peluchePrice = getString(R.string.pepeluche_price)

        foodList.add(Food(pelucheImage, pelucheName, pelucheDesc, peluchePrice))

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("food1", it.name)
            intent.putExtra("food2", it.description)
            intent.putExtra("food3", it.price)
            intent.putExtra("foodImage", it.image) // Asegúrate de pasar la imagen
            startActivity(intent)
        }

        return view
    }

}
