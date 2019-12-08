package com.pmultimedia.proyectotabs02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Tabs02 extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs02);
        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec fotospec = tabs.newTabSpec("fotos");
        fotospec.setIndicator("", res.getDrawable(R.drawable.ic_launcher_background));
        Intent photosIntent = new Intent(this, Fotografia.class);
        fotospec.setContent(photosIntent);
        TabHost.TabSpec musicaspec = tabs.newTabSpec("musica");
        musicaspec.setIndicator("", res.getDrawable(R.drawable.ic_launcher_background));
        Intent songsIntent = new Intent(this, Musica.class);
        musicaspec.setContent(songsIntent);
        TabHost.TabSpec videospec = tabs.newTabSpec("videos");
        videospec.setIndicator("", res.getDrawable(R.drawable.ic_launcher_background));
        Intent videosIntent = new Intent(this, Videos.class);
        videospec.setContent(videosIntent);
        tabs.addTab(fotospec);
        tabs.addTab(musicaspec);
        tabs.addTab(videospec);
    }
}
