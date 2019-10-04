package com.example.proyecto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boton = (Button) findViewById(R.id.boton1);
        boton.setOnClickListener(this);
        /*boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setText("Boton pulsado");
            }
        });*/

    }

    @Override
    public void onClick(View v) {
        v.getId();
        boton.setText("Boton pulsado");
    }
}
