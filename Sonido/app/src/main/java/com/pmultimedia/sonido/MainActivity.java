package com.pmultimedia.sonido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GestorSonido gs = new GestorSonido(getApplicationContext());

        SeekBar sbVolumen = findViewById(R.id.seekBar1);
        SeekBar sbBalance = findViewById(R.id.seekBar2);
        SeekBar sbFrecuencia = findViewById(R.id.seekBar3);

        SeekBar.OnSeekBarChangeListener barChange = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.seekBar1:
                        break;

                    case R.id.seekBar2:
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sbVolumen.setOnSeekBarChangeListener(barChange);
        sbBalance.setOnSeekBarChangeListener(barChange);
        sbFrecuencia.setOnSeekBarChangeListener(barChange);

    }

    public void pulsado(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.button1:
                break;

            case R.id.button2:
                break;

            case R.id.button3:
                break;

            default:
                break;
        }

    }
}
