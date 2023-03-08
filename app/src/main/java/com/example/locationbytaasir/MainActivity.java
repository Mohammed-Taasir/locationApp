package com.example.locationbytaasir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView Latextview, Longtextview;
    private LocationManager locationManager;
    private Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latextview = findViewById(R.id.latitude);
        Longtextview = findViewById(R.id.longitude);
//        button = findViewById(R.id.button);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);         // locationManager ko initialize kiya aur agar permission granted nai hai already toh request ki permission ki. aur fir location updates request ki har 10ms me aur 1m ki error pe.



//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

                if((ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)){
                    {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    }
                }

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 1, new LocationListener() { // location updates har 10ms me ayegi aur agar user 1m se zyada distance travel karta hai to bhi updataes ayegi

                    @Override
                    public void onLocationChanged(@NonNull Location location) {     // aur jese hi location updates aati hai to ye saari callback methods call hogi. thats why they are called callback methods.
                        Longtextview.setText(String.valueOf(location.getLongitude()));
                        Latextview.setText(String.valueOf(location.getLatitude()));
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                        LocationListener.super.onStatusChanged(provider, status, extras);
                    }

                    @Override
                    public void onProviderEnabled(@NonNull String provider) {
                        LocationListener.super.onProviderEnabled(provider);
                    }

                    @Override
                    public void onProviderDisabled(@NonNull String provider) {
                        LocationListener.super.onProviderDisabled(provider);
                    }

                });
//            }
//        });


    }
}