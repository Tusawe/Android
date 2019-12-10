package com.pmultimedia.proyectolv03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listas03 extends AppCompatActivity {

    private ListView list;
    private String[] pintores = {"CARAVAGGIO", "RAFAEL SANZIO", "VELAZQUEZ",
            "MIGUEL ANGEL", "REMBRANDT", "BOTICELLI", "LEONARDO DA VINCI", "RENOIR"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas03);
        list = (ListView)findViewById(R.id.listado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                R.layout.elemento,R.id.listado,pintores);
        list.setAdapter(adaptador);
    }
}
