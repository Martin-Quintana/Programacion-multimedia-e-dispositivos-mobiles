package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.i("ciclo","Ejecutando onCreate() ACTIVITY 2");//Mensaje de log
    }//fin de onCreate()

    //Incluir metodos del ciclo de vida para ver que esta haciendo en cada momento
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart() ACTIVITY 2");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop() ACTIVITY 2");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy() ACTIVITY 2");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume() ACTIVITY 2");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause() ACTIVITY 2");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart() ACTIVITY 2");//Mensaje de log
    }
}