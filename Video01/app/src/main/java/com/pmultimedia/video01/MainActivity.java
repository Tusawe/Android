package com.pmultimedia.video01;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView video;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaController = new MediaController(MainActivity.this);
        video = findViewById(R.id.videoView);
        video.setVideoPath("/storage/emulated/0/WhatsApp/Media/WhatsApp Video/VID-20200208-WA0049.mp4");
        //video.setVideoURI(Uri.parse("https://www.youtube.com/add_favorite?v=7-eziSprrW0"));
        //video.setVideoURI(Uri.parse("https://youtu.be/7-eziSprrW0"));
        mediaController.setAnchorView(video);
        video.setMediaController(mediaController);
        video.start();
        video.requestFocus();


    }
}
