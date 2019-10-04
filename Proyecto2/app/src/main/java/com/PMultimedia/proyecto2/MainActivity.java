package com.PMultimedia.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*boton = findViewById(R.id.boton);
        boton.setOnClickListener(this);*/

        Log.i("Estado","Estoy en onCreate");

    }

    public void pulsado(View v) {
        finish();
    }

    public void onStart() {
        super.onStart();
        Log.i("Estado","Estoy en onStart");
    }

    public void onResume() {
        super.onResume();
        Log.i("Estado","Estoy en onResume");
    }

    public void onPause() {
        super.onPause();
        Log.i("Estado","Estoy en onPause");
    }

}
