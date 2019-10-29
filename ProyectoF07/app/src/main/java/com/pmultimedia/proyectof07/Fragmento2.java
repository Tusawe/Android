package com.pmultimedia.proyectof07;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Fragmento2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn1 = (Button) getActivity().findViewById(R.id.importarTexto12);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.text1);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_LONG).show();
            }
        });

        Button btn2 = (Button) getActivity().findViewById(R.id.importarTexto22);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView texto = (TextView) getActivity().findViewById(R.id.text2);
                texto.setText("TOCADO FRAG2");
            }
        });

    }
}
