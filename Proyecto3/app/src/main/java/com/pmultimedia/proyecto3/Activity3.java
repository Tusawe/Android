package com.pmultimedia.proyecto3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void salto4(View v) {

        Intent saltar = new Intent(this,Activity4.class);
        startActivity(saltar);

    }

    public void salto6(View v) {

        Intent saltar = new Intent(this,Activity6.class);
        startActivity(saltar);

    }

}
