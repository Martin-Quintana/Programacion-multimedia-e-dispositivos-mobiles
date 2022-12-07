package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class _3_SpinnerAdaptadorRecursosActivity extends AppCompatActivity {

    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_spinner_adaptador_recursos);

        spPlanetas = findViewById(R.id.spPlanetas);

        //Crear adaptador --los datos se obtienen desde un recurso--
        //==========================================================

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                                                    R.array.planetas,
                                                    android.R.layout.simple_spinner_dropdown_item);


        //asignar el adaptador a la vista
        spPlanetas.setAdapter(arrayAdapter);

        //crear listenner de la vista tipo Spinner
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta_v2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(_3_SpinnerAdaptadorRecursosActivity.this,
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