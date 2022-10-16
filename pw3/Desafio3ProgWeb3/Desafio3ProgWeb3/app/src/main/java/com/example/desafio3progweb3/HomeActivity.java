package com.example.desafio3progweb3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

        Snackbar snackbar = Snackbar
                .make(findViewById(android.R.id.content), "App Pronto", Snackbar.LENGTH_LONG);
        snackbar.show();

    }

}
