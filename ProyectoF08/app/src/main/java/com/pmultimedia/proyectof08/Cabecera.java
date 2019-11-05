package com.pmultimedia.proyectof08;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Cabecera extends ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Elementos.Cabeceras));

    }

    public interface CabeceraListener{
        public void tocado(int position);
    }

    CabeceraListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (CabeceraListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.tocado(position);
    }
}
