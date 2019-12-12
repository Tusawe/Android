package com.pmultimedia.sensores08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Sensores08 extends AppCompatActivity implements SensorEventListener {

    public static int x;
    public static int y;
    private static int centrox = 250;
    private static int centroy = 250;
    private static SensorManager sensorManager;
    private static Sensor acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores08);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        MiVistaPersonal miVista = new MiVistaPersonal(this);

        ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.lay);
        mainLayout.addView(miVista);



    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = centrox + (int)Math.pow(event.values[1],2);
        y = centroy + (int)Math.pow(event.values[2],2);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}




