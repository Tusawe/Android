package com.example.material_design_05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    private void mensaje(int resid){
        CoordinatorLayout layoutCoordinador = findViewById(R.id.layoutCoordinador);
        Snackbar snackbar = Snackbar.make(layoutCoordinador, getText(resid),
                Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.barra_nuevo: mensaje(R.string.cadena_barra_nuevo);
                return true;
            case R.id.barra_editar: mensaje(R.string.cadena_barra_editar);
                return true;
            case R.id.barra_configurar: mensaje(R.string.cadena_barra_configurar);
                return true;
            case R.id.barra_ayuda: mensaje(R.string.cadena_barra_ayuda);
                return true;
            case R.id.barra_acerca: mensaje(R.string.cadena_barra_acerca);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
