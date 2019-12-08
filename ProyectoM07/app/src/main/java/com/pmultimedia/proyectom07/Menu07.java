package com.pmultimedia.proyectom07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class Menu07 extends AppCompatActivity {

    private CheckBox MCompleto;
    private TextView mensaje;
    private static final int MnuOpc4 = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu07);
        MCompleto = (CheckBox)findViewById(R.id.MCompleto);
        mensaje = (TextView)findViewById(R.id.Mensaje);
    }
    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        menu.clear();
        if(MCompleto.isChecked())
            nuevoMenu(menu, true);
        else
            nuevoMenu(menu, false);
        return super.onPrepareOptionsMenu(menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        nuevoMenu(menu, false);
        return true;
    }
    private void nuevoMenu(Menu menu, boolean extendido)
    {
        getMenuInflater().inflate(R.menu.menu07, menu);
        if(extendido)
            menu.add(Menu.NONE, MnuOpc4, Menu.NONE, "OPCIÓN DE MENÚ 4")
                    .setIcon(android.R.drawable.ic_menu_camera);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                mensaje.setText("OPCIÓN A PULSADA");
                return true;
            case R.id.MnuOpc2:
                mensaje.setText("OPCIÓN B PULSADA");
                return true;
            case R.id.MnuOpc3:
                mensaje.setText("OPCIÓN C PULSADA");
                return true;
            case R.id.SubMen1:
                mensaje.setText("OPCIÓN C-1 PULSADA");
                return true;
            case R.id.SubMen2:
                mensaje.setText("OPCIÓN C-2 PULSADA");
                return true;
            case MnuOpc4:
                mensaje.setText("OPCIÓN D PULSADA");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
