package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // Recuperar el intent que provoco la llamada
        Intent intent = getIntent();

        // Recuperar el bundle
        Bundle bundle = intent.getExtras();

        // Extraer los datos del bundle
        String strDatosRecibidos = bundle.getString("mensajeEnBundle");

        // Mostrar el dato en la TextView
        TextView txtRecibida = findViewById(R.id.txtDatosRecibidos);
        txtRecibida.setText(strDatosRecibidos);
    }

}