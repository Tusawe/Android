package com.pmultimedia.proyectotabs03;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmento1 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento1, container, false);
        TextView tv = (TextView) v.findViewById(R.id.texto);
        tv.setText("TOCADA LA PESTAÑA: "+this.getTag());
        return v;
    }
}
