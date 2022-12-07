package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Recuperar el intent que provoco la llamada
        Intent intent = getIntent();

        // Extraer el dato que venia con el intent
        String strDatoRecibido = intent.getStringExtra("mensaje");

        // Mostrar el dato en la TextView
        TextView txtRecibida = findViewById(R.id.txtDatosRecibidos);
        txtRecibida.setText(strDatoRecibido);
    }
}