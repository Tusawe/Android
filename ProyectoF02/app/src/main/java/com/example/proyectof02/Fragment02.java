package com.example.proyectof02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Fragment02 extends AppCompatActivity {

    FragmentManager FM = getSupportFragmentManager();
    FragmentTransaction FT = FM.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment02);

    }

    public void pulsar1(View v) {

        Fragmento1 fragment1 = new Fragmento1();
        FT.add(R.id.contenedor, fragment1);
        FT.commit();

    }

    public void pulsar2(View v) {

        Fragmento2 fragment2 = new Fragmento2();
        FT.add(R.id.contenedor, fragment2);
        FT.commit();

    }

}
