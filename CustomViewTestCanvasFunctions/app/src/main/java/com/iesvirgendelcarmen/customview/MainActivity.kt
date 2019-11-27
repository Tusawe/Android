package com.iesvirgendelcarmen.customview

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var customView: CustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        customView = findViewById<CustomView>(R.id.customView)
//        customView.paint = Paint().apply {
//            color = Color.RED
//        }

//        val boton = findViewById<Button>(R.id.button)
//        boton.setOnClickListener {
//            customView.paint = Paint().apply {
//                color = Color.GREEN
//            }
//        }

    }
}
