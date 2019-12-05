package com.dinterfaces.sleepapprecyclerview

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class PosturaViewModel : ViewModel() {
    companion object {
        private const val TAG = "PosturaViewModel"
    }

    lateinit var posturas: MutableList<Postura>

    init {
        Log.d(TAG, "PosturaViewModel created")
        mock()
    }

    override fun onCleared() {
        Log.d(TAG, "PosturaViewModel destroyed")
    }

    fun mock() {

        val p1 = Postura("POSICION FETAL",
            "\"Agugu-tata...\"",
            R.drawable.postura2)

        val p2 = Postura("EL CHIQUITO",
            "\"¡Por la gloria de mi madre!\"",
            R.drawable.postura3)

        val p3 = Postura("LA PLANCHA",
            "\"Uff, me duele la espalda...\"",
            R.drawable.postura4)

        val p4 = Postura("EL BORRACHO",
            "\"Lo jurro, la jultima y nosh vamo\"",
            R.drawable.postura5)

        val p5 = Postura("EL MUERTO",
            "\"...\"",
            R.drawable.postura6)

        val p6 = Postura("EL MUERTO PRO",
            "\"......\"",
            R.drawable.postura7)

        val p7 = Postura("HAMLET",
            "\"Ser, o no ser\"",
            R.drawable.postura8)

        val p8 = Postura("LA MALDITA LUZ",
            "\"¿Pero de donde viene?\"",
            R.drawable.postura9)

        val p9 = Postura("KARATE KID",
            "\"Dal sela, pulil sela\"",
            R.drawable.postura10)

        val p10 = Postura("EL HAMBRIENTO",
            "\"Como me comía un kebab de mortadela...\"",
            R.drawable.postura11)

        posturas = mutableListOf(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10)

        for (i in 0..150) {
            posturas.add(posturas[Random.nextInt(5)])
        }

    }
}