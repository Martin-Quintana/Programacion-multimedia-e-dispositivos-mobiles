package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.i("ciclo", "Activity 2 - Ejecutando onCreate()");//Mensaje de log
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo", "Activity 2 - Ejecutando onStart()");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo", "Activity 2 - Ejecutando onStop()");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo", "Activity 2 - Ejecutando onDestroy()");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo", "Activity 2 - Ejecutando onResume()");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo", "Activity 2 - Ejecutando onPause()");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo", "Activity 2 - Ejecutando onRestart()");//Mensaje de log
    }

}