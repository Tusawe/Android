package com.pmultimedia.sleepapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements Fragmento1.Callbacks {

    private Intent detalleIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onEntradaSeleccionada(String id) {
        Toast.makeText(getBaseContext(),"Has seleccionado el " + (Integer.parseInt(id) + 1) + "º", Toast.LENGTH_SHORT).show();
        detalleIntent = new Intent(this, Fragmento2.class);
        detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
        startActivity(detalleIntent);
    }
}
