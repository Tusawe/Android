package com.example.proyectof02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Fragment02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment02);

        Fragmento1 fragmento1 = new Fragmento1();
        Fragmento2 fragmento2 = new Fragmento2();

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        WindowManager WM = getWindowManager();
        Display DP = WM.getDefaultDisplay();

        if (DP.getRotation() == Surface.ROTATION_90) {

            FT.replace(R.id.contenedor, fragmento1).commit();

        } else  {

            FT.replace(R.id.contenedor, fragmento2).commit();

        }

    }

}
