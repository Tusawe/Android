package com.pmultimedia.proyectom04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class Menu04 extends AppCompatActivity {

    public static final int MNU_OPC1 = 1;
    private static final int MNU_OPC2 = 2;
    private static final int MNU_OPC3 = 3;
    public static final int MNU_OPC1A = 4;
    private static final int MNU_OPC1B = 5;
    private static final int MNU_OPC2A = 6;
    public static final int MNU_OPC2B = 7;
    private static final int MNU_OPC3A = 8;
    private static final int MNU_OPC3B = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu04);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu smnu1 = menu.addSubMenu(Menu.NONE, MNU_OPC1, Menu.NONE, "Opcion A desde Java").setIcon(android.R.drawable.ic_menu_preferences);
        smnu1.add(Menu.NONE, MNU_OPC1A, Menu.NONE, "Opcion A.1");
        smnu1.add(Menu.NONE, MNU_OPC1B, Menu.NONE, "Opcion A.2");
        SubMenu smnu2 = menu.addSubMenu(Menu.NONE, MNU_OPC2, Menu.NONE, "Opcion B desde Java").setIcon(android.R.drawable.ic_menu_compass);
        smnu2.add(Menu.NONE, MNU_OPC2A, Menu.NONE, "Opcion B.1");
        smnu2.add(Menu.NONE, MNU_OPC2B, Menu.NONE, "Opcion B.2");
        SubMenu smnu3 = menu.addSubMenu(Menu.NONE, MNU_OPC3, Menu.NONE, "Opcion C desde Java").setIcon(android.R.drawable.ic_menu_agenda);
        smnu3.add(Menu.NONE, MNU_OPC3A, Menu.NONE, "Opcion C.1");
        smnu3.add(Menu.NONE, MNU_OPC3B, Menu.NONE, "Opcion C.2");
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
            case 4:
                mensaje="¡¡¡Subopción A1 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 5:
                mensaje="¡¡¡Subopción A2 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 6:
                mensaje="¡¡¡Subopción B1 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 7:
                mensaje="¡¡¡Subopción B2 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 8:
                mensaje="¡¡¡Subopción C1 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            case 9:
                mensaje="¡¡¡Subopción C2 Pulsada!!!";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

