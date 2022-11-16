package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }// fin de onCreate()

    public void onClickBtnFinalizar(View view) {
        String datoRespuesta = "La actividad 5 responde HOLA a la actividad 1";


    }
}