package com.pmultimedia.proyecto3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
    }

    public void salto1(View v) {

        Intent saltar = new Intent(this,MainActivity.class);
        startActivity(saltar);

    }

    public void salto2(View v) {

        Intent saltar = new Intent(this,Activity2.class);
        startActivity(saltar);

    }

    public void exit(View v) {

//      finish();
//      System.exit(0);
//      onBackPressed();

        Intent salir = new Intent(Intent.ACTION_MAIN);
        salir.addCategory(Intent.CATEGORY_HOME);
        salir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(salir);

    }

}
