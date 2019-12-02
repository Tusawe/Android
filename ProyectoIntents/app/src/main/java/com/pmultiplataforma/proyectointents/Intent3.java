package com.pmultiplataforma.proyectointents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Intent3 extends AppCompatActivity {

    private TextView tv_fecha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent3);

        String anio = String.valueOf(getIntent().getExtras().getInt("anioActual"));

        tv_fecha = findViewById(R.id.txt_anio);
        tv_fecha.setText(anio);

    }
}
