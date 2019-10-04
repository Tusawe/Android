package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Acceso a los elementos del layout.
        val textView = findViewById<TextView>(R.id.holaMundo1)
        textView.text = "Texto desde codigo."

        // Otra de forma de acceder (solo Kotlin)
        holaMundo2.text = "ADIOS MUNDO!!"


    }

}
