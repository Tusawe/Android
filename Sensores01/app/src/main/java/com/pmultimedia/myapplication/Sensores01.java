package com.pmultimedia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Sensores01 extends AppCompatActivity {

    private TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores01);

        texto2 = findViewById(R.id.texto2);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : listaSensores) {

            texto2.append(sensor.getName()+"\n");

        }

    }
}
