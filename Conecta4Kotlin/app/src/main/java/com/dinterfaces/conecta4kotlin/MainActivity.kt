package com.dinterfaces.conecta4kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var botones = Array<Array<Button?>>(7) { arrayOfNulls(6)}
    lateinit var player1 : TextView
    lateinit var player2 : TextView
    lateinit var playerTurn : TextView
    lateinit var players : String
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

        player1 = findViewById(R.id.textViewPlayer1) as TextView
        player1.text = "Jugador 1-> ${player1points} puntos"

        player2 = findViewById(R.id.textViewPlayer2) as TextView
        player2.text = "Jugador 2-> ${player2points} puntos"

        playerTurn = findViewById(R.id.textViewTurn) as TextView
        if (player1turn) players = "jugador 1"
        else players = "jugador 2"
        playerTurn.text = "Turno del ${players}"

    }

    override fun onClick(v: View?) {

        turns++

        val boton = v as Button
        var x = 0
        // var y = 0

        // Averiguamos la posicion en el array.
        for (bx in 0 until 7) {

            for (by in 0 until 6) {

                if (boton.id == botones[bx][by]?.id) {

                    x = bx
                    // y = by

                }

            }

        }

        // Buscamos el ultimo valor

        for (fila in 5 downTo 0) {

            if (setButton(x, fila)) break

        }

    }

    private fun setButton(x: Int, fila: Int): Boolean {
        if (botones[x][fila]?.text == "") {

            if (player1turn) {
                botones[x][fila]?.text = "X"
            } else {
                botones[x][fila]?.text = "O"
            }

            if (checkWinner()) {

                if (player1turn) {

                    player1points++
                    player1.text = "Jugador 1-> ${player1points} puntos"

                } else {

                    player2points++
                    player2.text = "Jugador 2-> ${player2points} puntos"

                }

                resetBoard()

            } else {

                if (turns == 42) {

                    resetBoard()

                }

            }

            player1turn = !player1turn

            if (player1turn) players = "jugador 1"
            else players = "jugador 2"

            playerTurn.text = "Turno del ${players}"

            return true

        }
        return false
    }


    private fun resetBoard() {

        for (x in 0 until 7) {

            for (y in 0 until 6) {

                botones[x][y]?.text = ""

            }

        }

        turns = 0
        player1turn = false

    }

    private fun checkWinner() : Boolean {

        // Comprobamos el 4 en línea en vertical.
        for (i in 0 until 3) {

            for (x in 0 until 7) {

                if (botones[x][0+i]?.text == botones[x][1+i]?.text &&
                    botones[x][0+i]?.text == botones[x][2+i]?.text &&
                    botones[x][0+i]?.text == botones[x][3+i]?.text &&
                    botones[x][0+i]?.text != "") return true

            }

        }

        // Comprobamos el 4 en línea en horizontal.
        for (i in 0 until 4) {

            for (y in 0 until 6) {

                if (botones[0+i][y]?.text == botones[1+i][y]?.text &&
                    botones[0+i][y]?.text == botones[2+i][y]?.text &&
                    botones[0+i][y]?.text == botones[3+i][y]?.text &&
                    botones[0+i][y]?.text != "") return true

            }

        }

        // Comprobamos el 4 en línea en diagonal de izquierdas y arriba a derechas y abajo.
        if (botones[0][3]?.text == botones[1][2]?.text &&
            botones[0][3]?.text == botones[2][1]?.text &&
            botones[0][3]?.text == botones[3][0]?.text &&
            botones[0][3]?.text != "") return true

        for (i in 0 until 2) {

            if (botones[0+i][4-i]?.text == botones[1+i][3-i]?.text &&
                botones[0+i][4-i]?.text == botones[2+i][2-i]?.text &&
                botones[0+i][4-i]?.text == botones[3+i][1-i]?.text &&
                botones[0+i][4-i]?.text != "") return true

        }

        for (i in 0 until 3) {

            if (botones[0+i][5-i]?.text == botones[1+i][4-i]?.text &&
                botones[0+i][5-i]?.text == botones[2+i][3-i]?.text &&
                botones[0+i][5-i]?.text == botones[3+i][2-i]?.text &&
                botones[0+i][5-i]?.text != "") return true

        }

        for (i in 0 until 3) {

            if (botones[1+i][5-i]?.text == botones[2+i][4-i]?.text &&
                botones[1+i][5-i]?.text == botones[3+i][3-i]?.text &&
                botones[1+i][5-i]?.text == botones[4+i][2-i]?.text &&
                botones[1+i][5-i]?.text != "") return true

        }

        for (i in 0 until 2) {

            if (botones[2+i][5-i]?.text == botones[3+i][4-i]?.text &&
                botones[2+i][5-i]?.text == botones[4+i][3-i]?.text &&
                botones[2+i][5-i]?.text == botones[5+i][2-i]?.text &&
                botones[2+i][5-i]?.text != "") return true

        }

        if (botones[3][5]?.text == botones[4][4]?.text &&
            botones[3][5]?.text == botones[5][3]?.text &&
            botones[3][5]?.text == botones[6][2]?.text &&
            botones[3][5]?.text != "") return true

        // Comprobamos el 4 en línea en diagonal de izquierdas y abajo a derechas y arriba.
        if (botones[0][2]?.text == botones[1][3]?.text &&
            botones[0][2]?.text == botones[2][4]?.text &&
            botones[0][2]?.text == botones[3][5]?.text &&
            botones[0][2]?.text != "") return true

        for (i in 0 until 2) {

            if (botones[0+i][1+i]?.text == botones[1+i][2+i]?.text &&
                botones[0+i][1+i]?.text == botones[2+i][3+i]?.text &&
                botones[0+i][1+i]?.text == botones[3+i][4+i]?.text &&
                botones[0+i][1+i]?.text != "") return true

        }

        for (i in 0 until 3) {

            if (botones[0+i][0+i]?.text == botones[1+i][1+i]?.text &&
                botones[0+i][0+i]?.text == botones[2+i][2+i]?.text &&
                botones[0+i][0+i]?.text == botones[3+i][3+i]?.text &&
                botones[0+i][0+i]?.text != "") return true

        }

        for (i in 0 until 3) {

            if (botones[1+i][0+i]?.text == botones[2+i][1+i]?.text &&
                botones[1+i][0+i]?.text == botones[3+i][2+i]?.text &&
                botones[1+i][0+i]?.text == botones[4+i][3+i]?.text &&
                botones[1+i][0+i]?.text != "") return true

        }

        for (i in 0 until 2) {

            if (botones[2+i][0+i]?.text == botones[3+i][1+i]?.text &&
                botones[2+i][0+i]?.text == botones[4+i][2+i]?.text &&
                botones[2+i][0+i]?.text == botones[5+i][3+i]?.text &&
                botones[2+i][0+i]?.text != "") return true

        }

        if (botones[3][0]?.text == botones[4][1]?.text &&
            botones[3][0]?.text == botones[5][2]?.text &&
            botones[3][0]?.text == botones[6][3]?.text &&
            botones[3][0]?.text != "") return true

        return false

    }

}
