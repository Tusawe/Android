package com.pmultimedia.proyectolv01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listas01 extends AppCompatActivity {

    private ListView list;
    private String[] pintores = {"CARAVAGGIO", "RAFAEL SANZIO", "VELAZQUEZ",
            "MIGUEL ANGEL", "REMBRANDT", "BOTICELLI", "LEONARDO DA VINCI", "RENOIR"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas01);
        list = (ListView)findViewById(R.id.listado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, pintores);
        list.setAdapter(adaptador);
    }
}
