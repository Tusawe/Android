package com.pmultimedia.actionbar02;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActionBar02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar02);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.barra_personal);
        View view =getSupportActionBar().getCustomView();
        ImageButton imageButton=
                (ImageButton)view.findViewById(R.id.action_bar_atrás);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageButton imageButton2=
                (ImageButton)view.findViewById(R.id.action_bar_adelante);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"BOTÓN SIGUIENTE TOCADO",Toast.LENGTH_LONG).show();
            }
        });
    }
}
