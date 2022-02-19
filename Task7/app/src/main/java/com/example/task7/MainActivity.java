package com.example.task7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume() {
        super.onResume();

        LocationManager mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = mgr.isProviderEnabled(LocationManager.GPS_PROVIDER);
        Button b = findViewById(R.id.locationButton);
        b.setEnabled(enabled);


    }

    public void gotoLocation(View v) {
        startActivity(new Intent(getApplicationContext(), LocationActivity.class));
    }

    public void gotoSensor(View v) {
        Intent i = new Intent(getApplicationContext(), SensorActivity.class);

        if(v.getId() == R.id.accelerationButton) {
            i.putExtra("SENSOR_TYPE", "ACCELEROMETER");
        } else {
            i.putExtra("SENSOR_TYPE", "LIGHT");
        }

        startActivity(i);
    }
}