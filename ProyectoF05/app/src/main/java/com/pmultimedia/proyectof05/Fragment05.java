package com.pmultimedia.proyectof05;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Fragment05 extends AppCompatActivity {

    FragmentManager FM = getFragmentManager();
    FragmentTransaction FT = FM.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment05);

        Fragmento1 preferencias = new Fragmento1();
        FT.replace(android.R.id.content, preferencias);
        FT.commit();

    }
}
