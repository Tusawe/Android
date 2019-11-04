package com.pmultimedia.proyectof08;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class Fragment08 extends FragmentActivity implements Cabecera.CabeceraListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment08);

        Cabecera primerFragmento = new Cabecera();
        primerFragmento.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction()
                .add(R.id.contenedor, primerFragmento).commit();

    }

    public void tocado(int position) {



    }

}
