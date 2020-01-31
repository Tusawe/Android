package com.pmultimedia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class Imagen01 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen01);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);

        DisplayMetrics metrica = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrica);

        text1.setText("Ancho de pantalla: " + metrica.widthPixels);
        text2.setText("Alto de pantalla: " + metrica.heightPixels);
        text3.setText("Densidad de pantalla: " + metrica.densityDpi);
        text4.setText("Escala de pantalla: " + metrica.scaledDensity);

        switch (metrica.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                text5.setText("Densidad baja.");
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                text5.setText("Densidad media.");
                break;
            case DisplayMetrics.DENSITY_HIGH:
                text5.setText("Densidad alta.");
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                text5.setText("Densidad extra alta.");
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                text5.setText("Densidad super extra alta.");
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                text5.setText("Densidad super mega extra alta.");
                break;
            default:
                text5.setText("Densidad desconocida.");
        }

    }
}
