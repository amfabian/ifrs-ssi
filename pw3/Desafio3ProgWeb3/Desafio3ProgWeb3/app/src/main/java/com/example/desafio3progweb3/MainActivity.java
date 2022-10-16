package com.example.desafio3progweb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Intent intencao = new Intent(this, HomeActivity.class);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 20 milliseconds.
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if(progressStatus == 100) {
                            startActivity(intencao);
                        }
                    }
                }
            }
        }).start();


    }
}