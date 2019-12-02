package com.dinterfaces.ejercicio5view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

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
        barra.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                CustomView.velocidad = seekBar!!.progress.toLong()
            }

        })

    }

}
