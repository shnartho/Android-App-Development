package com.example.task7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.TextView;

import java.security.Provider;
import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
    }

    public void onResume() {
        super.onResume();
        SensorManager mgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        Intent i = getIntent();

        List<Sensor> sensors = mgr.getSensorList(i.getStringExtra("SENSOR_TYPE").equals("LIGHT") ? Sensor.TYPE_LIGHT : Sensor.TYPE_ACCELEROMETER);
        ((TextView)findViewById(R.id.sensorType)).setText(i.getStringExtra("SENSOR_TYPE"));
        if(sensors.isEmpty()){

            ((TextView)findViewById(R.id.sensorCount)).setText("a");
            ((TextView)findViewById(R.id.sensorCount)).setText("Not Applicable");
        } else {
            ((TextView)findViewById(R.id.sensorCount)).setText(Integer.toString(sensors.size()));
            mgr.registerListener(this, sensors.get(0), 100_000, 1_000 );

        }
    }


    @Override
    public void onPause(){
        super.onPause();
        ((SensorManager) getSystemService(SENSOR_SERVICE)).unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Intent i = getIntent();

        if(i.getStringExtra("SENSOR_TYPE").equals("LIGHT")) {
            ((TextView) findViewById(R.id.sensorValue)).setText(String.format("value: %f , accuracy: %d", event.values[0], event.accuracy));
        } else {
            ((TextView) findViewById(R.id.sensorValue)).setText(String.format("value x: %f , value y: %f, value z: %f , accuracy: %d", event.values[0],event.values[1],event.values[2], event.accuracy));

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}