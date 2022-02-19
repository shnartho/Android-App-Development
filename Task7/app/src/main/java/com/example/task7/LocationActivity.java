package com.example.task7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity implements LocationListener {
    boolean deniedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void onResume() {
        super.onResume();
        LocationManager mgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        Intent i = getIntent();

        if(!mgr.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            ((TextView)findViewById(R.id.latitude)).setText("Not Applicable");
            ((TextView)findViewById(R.id.longitude)).setText("Not Applicable");
            ((TextView)findViewById(R.id.speed)).setText("Not Applicable");
            ((TextView)findViewById(R.id.accelerate)).setText("Not Applicable");



        } else {
            if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
            } else if(!deniedOnce){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            } else {
                ((TextView)findViewById(R.id.latitude)).setText("No Access");
                ((TextView)findViewById(R.id.longitude)).setText("No Access");
                ((TextView)findViewById(R.id.speed)).setText("No Access");
                ((TextView)findViewById(R.id.accelerate)).setText("No Access");

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int code, String[] permission, int[] result) {
        if(result[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            deniedOnce = true;
            Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onPause(){
        super.onPause();
        ((LocationManager) getSystemService(LOCATION_SERVICE)).removeUpdates(this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        ((TextView)findViewById(R.id.latitude)).setText(Double.toString(location.getLatitude()));
        ((TextView)findViewById(R.id.longitude)).setText(Double.toString(location.getLongitude()));
        ((TextView)findViewById(R.id.speed)).setText(Double.toString(location.getSpeed()));
        ((TextView)findViewById(R.id.accelerate)).setText(Double.toString(location.getAltitude()));

    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        Toast.makeText(getApplicationContext(), "Provider Enabled", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        Toast.makeText(getApplicationContext(), "Provider Disabled", Toast.LENGTH_SHORT).show();


    }
}