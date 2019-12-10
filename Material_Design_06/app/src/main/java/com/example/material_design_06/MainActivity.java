package com.example.material_design_06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("TAB 01");
        primerTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(primerTab);

        TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("TAB 02");
        segundoTab.setIcon(R.drawable.icono1);
        tabLayout.addTab(segundoTab);

        TabLayout.Tab tercerTab = tabLayout.newTab();
        tercerTab.setText("TAB 03");
        tercerTab.setIcon(R.drawable.ic_launcher_background);
        tabLayout.addTab(tercerTab,true);

<<<<<<< HEAD
=======
        //tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); Pone en el centro los tres tab
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tabLayout.setTabMode(TabLayout.MODE_FIXED);
>>>>>>> cede765070a70bc6254a7c56139990221d340437

        tabLayout.setTabTextColors(Color.RED, Color.WHITE);

    }
}
