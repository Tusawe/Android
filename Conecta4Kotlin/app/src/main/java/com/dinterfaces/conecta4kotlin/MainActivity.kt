package com.dinterfaces.conecta4kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var botones = Array<Array<Button?>>(7) { arrayOfNulls(6)}
    var player1points = 0
    var player2points = 0
    var player1turn = true
    var turns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (x in 0 until 7) {

            for (y in 0 until 6) {

                val id = resources.getIdentifier("button${x}${y}", "id", packageName)
                val boton = findViewById(id) as Button
                botones[x][y] = boton
                boton.text = ""
                boton.setOnClickListener(this)

            }

        }

    }

    override fun onClick(v: View?) {



    }

}
