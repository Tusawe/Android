package com.example.material_design_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CoordinatorLayout layoutCoordinador = findViewById(R.id.layoutCoordinador);
        FloatingActionButton fab = findViewById(R.id.fab);
        Button btnSimple = findViewById(R.id.btnSimple);
        Button btnPersonalizado = findViewById(R.id.btnPersonalizado);
        Button btnInteractivo = findViewById(R.id.btnInteractivo);

        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(layoutCoordinador, "EJEMPLO DE SNACKBAR",
                        Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        btnInteractivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(layoutCoordinador, "MENSAJE BORRADO",
                        Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(layoutCoordinador, "MENSAJE RESTAURADO",
                                Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
                snackbar.show();
            }
        });

        btnPersonalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(layoutCoordinador, "MENSAJE BORRADO",
                        Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(layoutCoordinador, "MENSAJE RESTAURADO",
                                Snackbar.LENGTH_SHORT);
                        snackbar1.setActionTextColor(Color.CYAN);
                        snackbar1.show();
                    }
                });

                snackbar.show();
            }
        });
    }
}
