package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class _3_SpinnerAdaptadorRecursosActivity extends AppCompatActivity {

    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_spinner_adaptador_recursos);

        spPlanetas = findViewById(R.id.spPlanetas);

        //Crear adaptador --los datos se obtienen desde un recurso--
        //==========================================================

        
    }
}