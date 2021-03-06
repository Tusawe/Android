package com.pmultimedia.proyectof10;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Fragment10 extends FragmentActivity implements Fragmento1.Callbacks {

    private Intent detalleIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment10);
    }

    @Override
    public void onEntradaSeleccionada(String id) {
        Toast.makeText(getBaseContext(),"TOCADO EL " + id, Toast.LENGTH_LONG).show();
        detalleIntent = new Intent(this, Fragmento2.class);
        detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
        startActivity(detalleIntent);
    }
}