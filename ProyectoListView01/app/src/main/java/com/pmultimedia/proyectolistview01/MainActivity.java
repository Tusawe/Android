package com.pmultimedia.proyectolistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private String[] pintores = {"CARAVAGGIO","RAFAEL SANZIO","VELAZQUEZ",
            "MIGUEL ANGEL", "REMBRANDT", "BOTICELLI", "LEONARDO", "RENOIR"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.activity_listview, R.id.text1, pintores);
        list.setAdapter(adaptador);
    }
}
