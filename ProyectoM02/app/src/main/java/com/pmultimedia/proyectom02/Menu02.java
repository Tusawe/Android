package com.pmultimedia.proyectom02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu02 extends AppCompatActivity {

    public static final int MNU_OPC1 = 1;
    private static final int MNU_OPC2 = 2;
    private static final int MNU_OPC3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu02);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MNU_OPC1, Menu.NONE, "Opcion A desde Java")
                .setIcon(android.R.drawable.ic_menu_preferences);
        menu.add(Menu.NONE, MNU_OPC2, Menu.NONE, "Opcion B desde Java")
                .setIcon(android.R.drawable.ic_menu_compass);
        menu.add(Menu.NONE, MNU_OPC3, Menu.NONE, "Opcion C desde Java")
                .setIcon(android.R.drawable.ic_menu_agenda);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensaje="";
        switch (item.getItemId()) {
            case 1:
                mensaje="¡¡¡Opción A Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                mensaje="¡¡¡Opción B Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                mensaje="¡¡¡Opción C Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
