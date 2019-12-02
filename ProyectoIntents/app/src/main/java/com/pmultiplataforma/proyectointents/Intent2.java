package com.pmultiplataforma.proyectointents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Intent2 extends AppCompatActivity {

    private TextView tv_nombre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent2);

        String nombre = getIntent().getExtras().getString("nombreIntent");

        tv_nombre = findViewById(R.id.txt_nombre);
        tv_nombre.setText(nombre);

    }
}
