package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class _2_SpinnerAdapterActivity extends AppCompatActivity {

    private Spinner spPlanetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_spinner_adapter);

        spPlanetas = findViewById(R.id.spPlanetas);
        //Creacion del array Planetas y lo rellenamos con los planetas
        String[] arrayPlanetas= {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter",
                "Saturno","Urano","Neptuno"};

    }


}