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
    var turns = 1

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

        val boton = v as Button
        var x = 0
        var y = 0

        // Averiguamos la posicion en el array.
        for (bx in 0 until 7) {

            for (by in 0 until 6) {

                if (boton.id == botones[bx][by]?.id) {

                    x = bx
                    y = by

                }

            }

        }

        // Buscamos el ultimo valor

        for (fila in 5 downTo 0) {

            if (botones[x][fila]?.text == "") {

                if (player1turn) {
                    botones[x][fila]?.text = "X"
                }
                else {
                    botones[x][fila]?.text = "O"
                }

                turns++
                player1turn = !player1turn

                break

            }

        }

    }

}
