package com.pmultimedia.proyecto3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }

    public void salto5(View v) {

        Intent saltar = new Intent(this,Activity5.class);
        startActivity(saltar);

    }

}
