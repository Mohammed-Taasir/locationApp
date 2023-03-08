package com.example.locationbytaasir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // first commit
    TextView Latextview, Longtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Latextview = findViewById(R.id.latitude);
        Longtextview = findViewById(R.id.longitude);
    }
}