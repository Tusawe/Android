package com.pmultimedia.proyecto3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
    }

    public void salto3(View v) {

        Intent saltar = new Intent(this,Activity3.class);
        startActivity(saltar);

    }

}
