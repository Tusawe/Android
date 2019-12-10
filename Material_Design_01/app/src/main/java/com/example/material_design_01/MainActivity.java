package com.example.material_design_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout controlNombre ;
    private EditText campoNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonAceptar = findViewById(R.id.btn_aceptar);
        campoNombre = findViewById(R.id.campoNombre);

        botonAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {validarDatos();}
        });


    }

    private boolean esNombreValido(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z]+$");

        if(!patron.matcher(nombre).matches()||nombre.length()>30){
            controlNombre.setError("ERROR EN NOMBRE");
            return false;
        } else  {
            controlNombre.setError(null);
        }
        return true;
    }

    private void validarDatos(){
        String nombre = controlNombre.getEditText().getText().toString();
        boolean a = esNombreValido(nombre);
        if(a){
            Toast.makeText(this, "REGISTRO CORRECTO", Toast.LENGTH_LONG).show();
        }
    }
}
