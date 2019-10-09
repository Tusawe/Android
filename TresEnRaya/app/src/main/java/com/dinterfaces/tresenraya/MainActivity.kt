package com.dinterfaces.tresenraya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var botones = Array<Array<Button?>>(3) { arrayOfNulls(3)}
    var player1points = 0
    var player2points = 0
    var player1turn = true
    var turns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (x in 0 until 3) {

            for (y in 0 until 3) {

                val id = resources.getIdentifier("boton${x+1}_${y+1}", "id", packageName)
                val boton = findViewById(id) as Button
                botones[x][y] = boton
                boton.text = ""
                boton.setOnClickListener(this)

            }

        }
    }

    override fun onClick(v: View?) {

        turns++

        val boton = v as Button

        if (boton.text != "") return

        if(player1turn) {

            boton.text = "X"

        } else {

            boton.text = "O"

        }

        if (checkWin()) {

            if (player1turn) {

                player1points++

            } else {

                player2points++

            }

            resetBoard()

        } else {

            if (turns == 9)  {

                resetBoard()

            }

        }

        player1turn = !player1turn


    }

    private fun resetBoard() {

        for (x in 0 until 3) {

            for (y in 0 until 3) {

                botones[x][y]?.text = ""

            }

        }

        turns = 0
        player1turn = true

    }

    fun checkWin () : Boolean {

        for (x in 0 until 3) {

            if (botones[x][0]?.text == botones[x][1]?.text &&
                    botones[x][0]?.text == botones[x][2]?.text &&
                    botones[x][0]?.text != "") return true

        }

        for (y in 0 until 3) {

            if (botones[0][y]?.text == botones[1][y]?.text &&
                botones[1][y]?.text == botones[2][y]?.text &&
                botones[2][y]?.text != "") return true

        }

        if (botones[0][0]?.text == botones[1][1]?.text &&
            botones[0][0]?.text == botones[2][2]?.text &&
            botones[0][0]?.text != "") return true

        if (botones[0][2]?.text == botones[1][1]?.text &&
            botones[0][2]?.text == botones[2][0]?.text &&
            botones[0][2]?.text != "") return true

        return false

    }

}
