package com.example.material_design_02;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setScaleX(0);
        fab.setScaleY(0);
        final Interpolator interpolator = AnimationUtils.loadInterpolator(getBaseContext(), );

        fab.animate()
        .scaleX(1)
        .scaleY(1)
        .setInterpolator(interpolator)
        .setDuration(600)
        .setStartDelay(1000)
        .setListener(new Animator.AnimatorListener(){
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                fab.animate()
                        .scaleX(0)
                        .scaleY(0)
                        .setInterpolator(interpolator)
                        .setDuration(600)
                        .start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "FAB TOCADO", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
