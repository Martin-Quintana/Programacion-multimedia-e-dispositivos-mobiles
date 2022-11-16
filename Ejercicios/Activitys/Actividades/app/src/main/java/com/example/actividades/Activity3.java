package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        //Recuperar el intent que provoco la llamada
        Intent intent = getIntent();

        //Extraer el dato que venia en el intent
        String strDatoRecibido = intent.getStringExtra("mensaje"); // Ponemos la clave del StrDatoEnviar descrito en la MainActivity

        //Mostrar el dato en la TextView reservada para ello
        TextView txtRecibido = findViewById(R.id.txtDatosRecibidos);
        txtRecibido.setText(strDatoRecibido);


    } //fin onCreate()
}