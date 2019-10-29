package com.dinterfaces.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerCountries = findViewById<Spinner>(R.id.spinnerCountries)
        // val adapter = ArrayAdapter<Country>(this, android.R.layout.simple_spinner_dropdown_item, CountryFactory.create())
        val adapter = CountryAdapter(this, CountryFactory.create())
        spinnerCountries.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { v ->

            val country = spinnerCountries.selectedItem as Country
            Toast.makeText(this, country.name, Toast.LENGTH_SHORT).show()

        }

    }
}
