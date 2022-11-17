package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        //Recuperar el intent que hizo la llamada
        Intent intent = getIntent();
        //Recupero los datos
        String strDato = intent.getStringExtra("mensaje_con_respuesta");
        //Mostrar el dato en la TextView reservada para ello
        TextView txtDatoRecibido = findViewById(R.id.txtDatosRecibidos2);
        txtDatoRecibido.setText(strDato);
        Log.i("ciclo","Ejecutando onCreate() de Activity5");//Mensaje de log
    }// fin de onCreate()

    //Incluir metodos del ciclo de vida para ver que esta haciendo en cada momento
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart() de Activity5");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop() de Activity5");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy() de Activity5");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume() de Activity5");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause() de Activity5");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart() de Activity5");//Mensaje de log
    }

    public void onClickBtnFinalizar(View view) {
        String datoRespuesta = "La actividad 5 responde HOLA a la actividad 1";
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("mensaje_devuelto", datoRespuesta);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}