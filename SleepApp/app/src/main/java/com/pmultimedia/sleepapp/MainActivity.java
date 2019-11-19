package com.pmultimedia.sleepapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements Fragmento1.Callbacks {

    private Intent detalleIntent;
    private Boolean dosFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.frame_contenedor)!=null){dosFragmentos = true;}

    }

    @Override
    public void onEntradaSeleccionada(String id) {

        Toast.makeText(getBaseContext(),"Has seleccionado el " + (Integer.parseInt(id) + 1) + "º", Toast.LENGTH_SHORT).show();

        if(dosFragmentos){

            Bundle arguments = new Bundle();
            arguments.putString(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            Fragmento3 fragment = new Fragmento3();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_contenedor, fragment).commit();

        } else {

            detalleIntent = new Intent(this, Fragmento2.class);
            detalleIntent.putExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, id);
            startActivity(detalleIntent);

        }

    }
}
