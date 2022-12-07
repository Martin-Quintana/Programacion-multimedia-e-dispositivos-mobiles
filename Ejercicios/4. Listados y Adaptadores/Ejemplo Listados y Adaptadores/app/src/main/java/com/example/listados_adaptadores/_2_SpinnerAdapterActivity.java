package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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


        //Crear adaptador
        //simple_spinner_item reduce el espacio entre las opciones del Spinner
        /*
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                                                                    android.R.layout.simple_spinner_item,
                                                                    arrayPlanetas);
                                                                    *
         */
        //Lo pone como si no tuviera adaptador
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                                                                    android.R.layout.simple_spinner_dropdown_item,
                                                                    arrayPlanetas);

        //asignar el adaptador a la vista
        spPlanetas.setAdapter(arrayAdapter);

        //crear listenner de la vista tipo Spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta_v2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(_2_SpinnerAdapterActivity.this,
                        "\n Planeta desde Spinner: " + strPlaneta
                                + "\n Planeta seleccionado desde adaptador: " + strPlaneta_v2
                        , Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //No es necesario
            }
        });

    }


}