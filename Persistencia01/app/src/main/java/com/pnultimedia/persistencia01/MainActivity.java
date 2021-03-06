package com.pnultimedia.persistencia01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private TextView textView1;
    private TextView textView2;
    private Button btnGuardar;
    private Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btnGuardar = findViewById(R.id.btn_guardar);
        btnRecuperar = findViewById(R.id.btn_recuperar);

        final SharedPreferences sPref = getSharedPreferences("persistencia", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sPref.edit();

    }
}
