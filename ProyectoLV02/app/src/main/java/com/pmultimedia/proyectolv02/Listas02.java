package com.pmultimedia.proyectolv02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listas02 extends AppCompatActivity {

    private ListView list;
    private String[] pintores = {"CARAVAGGIO", "RAFAEL SANZIO", "VELAZQUEZ",
            "MIGUEL ANGEL", "REMBRANDT", "BOTICELLI", "LEONARDO DA VINCI", "RENOIR"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas02);
        list = (ListView)findViewById(R.id.listado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, pintores);
        list.setAdapter(adaptador);
    }
}
