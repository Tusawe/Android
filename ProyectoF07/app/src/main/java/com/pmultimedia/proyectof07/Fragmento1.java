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

import org.w3c.dom.Text;

public class Fragmento1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn1 = (Button) getActivity().findViewById(R.id.importarTexto1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.text3);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_LONG).show();
            }
        });

        Button btn2 = (Button) getActivity().findViewById(R.id.importarTexto2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView texto = (TextView) getActivity().findViewById(R.id.text4);
                texto.setText("TOCADO FRAG1");
            }
        });

    }
}
