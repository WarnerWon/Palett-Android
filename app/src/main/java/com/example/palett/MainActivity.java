package com.example.palett;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar = null;
    private int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progress < 100){
                    progress++;
                    SystemClock.sleep(20);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }

    protected void init(){
        progressBar = findViewById(R.id.progress_view);

    }
}
