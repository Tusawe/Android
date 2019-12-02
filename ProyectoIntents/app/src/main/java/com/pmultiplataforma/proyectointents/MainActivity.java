package com.pmultiplataforma.proyectointents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button botonIntent1;
    private Button botonIntent2;
    private Button botonIntent3;
    private Button botonIntent4;
    private Button botonIntent5;
    private Button botonIntent6;
    private Button botonIntent7;
    private Button botonIntent8;
    private String nombre = "Pepelu";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonIntent1 = findViewById(R.id.btn_intent1);
        botonIntent2 = findViewById(R.id.btn_intent2);
        botonIntent3 = findViewById(R.id.btn_intent3);
        botonIntent4 = findViewById(R.id.btn_intent4);
        botonIntent5 = findViewById(R.id.btn_intent5);
        botonIntent6 = findViewById(R.id.btn_intent6);
        botonIntent7 = findViewById(R.id.btn_intent7);
        botonIntent8 = findViewById(R.id.btn_intent8);

        final Intent intent1 = new Intent(this, Intent1.class);
        final Intent intent2 = new Intent(this, Intent2.class);
        final Intent intent3 = new Intent(this, Intent3.class);
        final Intent intent4 = new Intent(this, Intent4.class);
        final Intent intent5 = new Intent(Intent.ACTION_VIEW);
        final Intent intent6 = new Intent(Intent.ACTION_WEB_SEARCH);
        final Intent intent7 = new Intent(Intent.ACTION_DIAL);
        final Intent intent8 = new Intent(Intent.ACTION_CALL);

        botonIntent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });

        botonIntent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra("nombreIntent", nombre);
                startActivity(intent2);
            }
        });

        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);

        botonIntent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent3.putExtra("anioActual", year);
                startActivity(intent3);
            }
        });

        final String txt1 = "Texto numero 1";
        final String txt2 = "Texto numero 2";
        final String txt3 = "Texto numero 3";
        final String txt4 = "Texto numero 4";
        final String txt5 = "Texto numero 5";

        botonIntent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent4.putExtra("texto1", txt1);
                intent4.putExtra("texto2", txt2);
                intent4.putExtra("texto3", txt3);
                intent4.putExtra("texto4", txt4);
                intent4.putExtra("texto5", txt5);
                startActivity(intent4);
            }
        });

        botonIntent5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent5.setData(Uri.parse("https://www.iesvirgendelcarmen.com/ies/index.php"));
                startActivity(intent5);
            }
        });

        botonIntent6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent6.putExtra(SearchManager.QUERY, "Jaén");
                startActivity(intent6);
            }
        });

        botonIntent7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent7.setData(Uri.parse("tel:1234567890"));
                startActivity(intent7);
            }
        });

//        botonIntent8.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("MissingPermission")
//            @Override
//            public void onClick(View view) {
//                intent8.setData(Uri.parse("tel:1234567890"));
//                startActivity(intent8);
//            }
//        });

    }
}
