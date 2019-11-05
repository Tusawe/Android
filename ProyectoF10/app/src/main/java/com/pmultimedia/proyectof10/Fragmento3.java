package com.pmultimedia.proyectof10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmento3 extends Fragment {

    public static final String ARG_ID_ENTRADA_SELECCIONADA = "item_id";

    public Fragmento3() {}

    private Contenido.Lista_entrada milItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey(ARG_ID_ENTRADA_SELECCIONADA)) {

            milItem = Contenido.ENT_LISTA_HASHMAP.get(getArguments()
                    .getString(ARG_ID_ENTRADA_SELECCIONADA));

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_detalle, container, false);
        if (milItem != null) {

            ((TextView) rootView.findViewById(R.id.textotitle)).setText(milItem.textoEncima);
            ((TextView) rootView.findViewById(R.id.textocontenido)).setText(milItem.textoDebajo);
            ((ImageView) rootView.findViewById(R.id.imagen)).setImageResource(milItem.idImagen);

        }

        return rootView;

    }
}
