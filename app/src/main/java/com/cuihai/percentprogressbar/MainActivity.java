package com.cuihai.percentprogressbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import view.PercentProgressBar;

public class MainActivity extends AppCompatActivity {
    PercentProgressBar percentProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        percentProgressBar = (PercentProgressBar) findViewById(R.id.percentProgressBar);
        percentProgressBar.setPercent(50);
        percentProgressBar.setOrgColor(Color.BLACK);
        percentProgressBar.setProColor(Color.RED);
    }
}
