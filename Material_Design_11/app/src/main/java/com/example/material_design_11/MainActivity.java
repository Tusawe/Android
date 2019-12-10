package com.example.material_design_11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView navigator;
    String titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        navigator = findViewById(R.id.navigator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        titulo = getResources().getString(R.string.menu1_1);

        setSupportActionBar(toolbar);

        final ActionBar abar = getSupportActionBar();
        if(abar!=null){
            abar.setHomeAsUpIndicator(R.drawable.menu);
            abar.setDisplayHomeAsUpEnabled(true);

        if(navigator != null){
            configuraDrawer(navigator);
        }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!drawer.isDrawerOpen(GravityCompat.START)){
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.opcion1:
                Toast.makeText(this, "OPCION 1 TOCADA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                Toast.makeText(this, "OPCION 2 TOCADA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion3:
                Toast.makeText(this, "OPCION 3 TOCADA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion4:
                Toast.makeText(this, "OPCION 4 TOCADA", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void configuraDrawer(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);
                        String title = menuItem.getTitle().toString();
                        respuesta(title);
                        return true;
                    }
                }
        );
    }

    private void respuesta(String title){
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        drawer.closeDrawers();
        setTitle(title);
    }


}
