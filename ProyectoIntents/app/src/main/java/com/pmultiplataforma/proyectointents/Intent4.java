package com.pmultiplataforma.proyectointents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Intent4 extends AppCompatActivity {

    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent4);

        String texto1 = getIntent().getExtras().getString("texto1");
        tv_1= findViewById(R.id.txt1);
        tv_1.setText(texto1);

        String texto2 = getIntent().getExtras().getString("texto2");
        tv_2= findViewById(R.id.txt2);
        tv_2.setText(texto2);

        String texto3 = getIntent().getExtras().getString("texto3");
        tv_3= findViewById(R.id.txt3);
        tv_3.setText(texto3);

        String texto4 = getIntent().getExtras().getString("texto4");
        tv_4= findViewById(R.id.txt4);
        tv_4.setText(texto4);

        String texto5 = getIntent().getExtras().getString("texto5");
        tv_5= findViewById(R.id.txt5);
        tv_5.setText(texto5);

    }
}
