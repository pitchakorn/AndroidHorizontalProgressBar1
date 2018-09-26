package com.example.topnt.androidhorizontalprogressbar1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    Handler handler;
    Runnable runnable;
    Timer timer;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);

        progressBar.setProgress(20);
        progressBar.setMax(100);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (i<=100){
                    progressBar.setProgress(i);
                    progressBar.setSecondaryProgress(i+10);
                }else {
                    progressBar.setVisibility(View.GONE);
                    timer.cancel();
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                i=i+1;
                handler.post(runnable);
            }
        },4000,400);
    }
}

