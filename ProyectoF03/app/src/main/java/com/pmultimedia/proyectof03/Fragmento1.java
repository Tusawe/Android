package com.pmultimedia.proyectof03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class Fragmento1 extends ListFragment {

    private String[] artistas = { "Alberto Durero","Miguel Ángel","Rafael Sanzio","Tiziano ",
            "Donatello ","Paolo Uccello","Giotto","Peter Breughel","F. Brunelleschi","Fra Angelico",
            "A. Mantegna","Leonardo","G. Bellini","S. Botticelli","Cosimo Rosselli","Masaccio",
            "Ghirlandaio","Giorgione","Filippino Lippi","P. della Francesca"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,artistas));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }
}


