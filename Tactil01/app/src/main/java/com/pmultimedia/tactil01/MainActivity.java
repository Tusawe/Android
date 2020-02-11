package com.pmultimedia.tactil01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout yellow;
    private LinearLayout red;
    private LinearLayout blue;
    private LinearLayout purple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yellow = findViewById(R.id.yellow);
        red = findViewById(R.id.red);
        purple = findViewById(R.id.purple);
        blue = findViewById(R.id.blue);

        yellow.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                Toast.makeText(getApplicationContext(), "Has tocado el amarillo.", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        red.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                Toast.makeText(getApplicationContext(), "Has tocado el rojo.", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        blue.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                Toast.makeText(getApplicationContext(), "Has tocado el azul.", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        purple.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                Toast.makeText(getApplicationContext(), "Has tocado el morado.", Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }
}
