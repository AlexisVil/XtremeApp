package com.xtremecorp.xtremeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PantallaDeCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_carga);

        getSupportActionBar().hide();

        final int DURATION=2500;

        Handler handler = new Handler();
        handler.postDelayed(()->{
            startActivity(new Intent(PantallaDeCarga.this, Inicio.class)); //Cambiar posteriormente a inicio.class
            finish();
        },DURATION);

    }
}