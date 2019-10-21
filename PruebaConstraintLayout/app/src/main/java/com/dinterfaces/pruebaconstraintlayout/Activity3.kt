package com.dinterfaces.pruebaconstraintlayout

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main3.*

class Activity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        animate()
    }

    fun animate() {

        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_main3_2)
        findViewById<ImageView>(R.id.imageView).setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                TransitionManager.beginDelayedTransition(root)
                val constraint = if(set) constraint1 else constraint2
                constraint.applyTo(root)
                set = !set

            }

        }

    }
}
