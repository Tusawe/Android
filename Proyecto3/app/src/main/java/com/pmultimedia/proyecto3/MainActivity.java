package com.pmultimedia.proyecto3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void salto7(View v) {

        Intent saltar = new Intent(this,FinalActivity.class);
        startActivity(saltar);

    }

}

