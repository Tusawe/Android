package com.dinterfaces.ejercicio5view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var boton : Button
    private lateinit var barra : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.button)
        boton.setOnClickListener {

            CustomView.giro = !CustomView.giro

        }

        barra = findViewById(R.id.seekBar)

    }

}
