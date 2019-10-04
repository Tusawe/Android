package com.DInterfaces.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_inc.setOnClickListener {
            if(counter < 15) {
                counter++
                txt_counter.text = counter.toString()
            }

        }

        btn_dec.setOnClickListener {
            if(counter > 0) {
                counter--
                txt_counter.text = counter.toString()
            }

        }

        btn_res.setOnClickListener {
            counter = 0
            txt_counter.text = counter.toString()
        }

    }
}
