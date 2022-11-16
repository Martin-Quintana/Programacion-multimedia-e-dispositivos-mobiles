package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        //Recuperar el intent que hizo la llamada
        Intent intent = getIntent();
        //Recupero el Bundle con los Datos
        Bundle bundle = intent.getExtras();
        //Extraer los datos del paquete
        String strDatosRecibidos = bundle.getString("mensaje_en_bundle");
        //Mostrar el dato en la TextView reservada para ello
        TextView txtRecibido = findViewById(R.id.txtDatosRecibidos);
        txtRecibido.setText(strDatosRecibidos);

    }//fin onCreate()


}