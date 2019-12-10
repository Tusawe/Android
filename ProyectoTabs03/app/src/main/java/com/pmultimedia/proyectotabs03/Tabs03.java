package com.pmultimedia.proyectotabs03;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;

public class Tabs03 extends FragmentActivity {
    private FragmentTabHost TabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs03);
        TabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        TabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        TabHost.addTab(
                TabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                Fragmento1.class, null);
        TabHost.addTab(
                TabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                Fragmento2.class, null);
        TabHost.addTab(
                TabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                Fragmento3.class, null);
    }
}
