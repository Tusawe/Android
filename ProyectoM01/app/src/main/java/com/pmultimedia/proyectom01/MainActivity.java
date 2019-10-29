package com.pmultimedia.proyectom01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private static final int MNU_OPC1 = 1;
//    private static final int MNU_OPC2 = 2;

    private static TextView etiqueta;
    private static TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta = (TextView) findViewById(R.id.text1);
        registerForContextMenu(etiqueta);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        String mensaje = "";
        switch (item.getItemId()){

            case R.id.item1:
                mensaje = "!Primera Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

            case R.id.item2:
                mensaje = "!Segunda Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

            case R.id.item3:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.iesvirgendelcarmen.com/ies/index.php"));
                startActivity(intent);
                return true;

            case R.id.item4:
                mensaje = "!Tercera Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

        }

        return false;

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
//        menu.add(Menu.NONE, MNU_OPC1, Menu.NONE, "Opcion A desde Java")
//        .setIcon(android.R.drawable.ic_menu_preferences);
//        menu.add(Menu.NONE, MNU_OPC2, Menu.NONE, "Opcion B desde Java")
//                .setIcon(android.R.drawable.ic_menu_preferences);
        return true;

    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String mensaje = "";
        switch (item.getItemId()){

            case R.id.item1:
                mensaje = "!Primera Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

            case R.id.item2:
                mensaje = "!Segunda Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

            case R.id.item3:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.iesvirgendelcarmen.com/ies/index.php"));
                startActivity(intent);
                return true;

            case R.id.item4:
                mensaje = "!Tercera Opcion Pulsada!";
                Toast.makeText(this, mensaje, 0).show();
                return true;

        }

        return false;

    }
}
