package com.example.material_design_07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("PRIMERO").setIcon(android.R.drawable.ic_menu_compass));
        tabLayout.addTab(tabLayout.newTab().setText("SEGUNDO").setIcon(android.R.drawable.ic_menu_compass));
        tabLayout.addTab(tabLayout.newTab().setText("TERCERO").setIcon(android.R.drawable.ic_menu_compass));

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;

                switch (tab.getPosition()){
                    case 0:
                        fragment = new Primero();
                    case 1:
                        fragment = new Segundo();
                    case 2:
                        fragment = new Tercero();
                }

                FragmentManager fm = getSupportFragmentManager();
                
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
