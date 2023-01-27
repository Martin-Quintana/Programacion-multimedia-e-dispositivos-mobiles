package com.example.listadosadaptadores;

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

        String[] arrayPlanetas = {"Mercurio", "Venus", "Tierra", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};

        // Crear el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayPlanetas);

        // Asignar el adptador a la vista
        spPlanetas.setAdapter(adapter);

        // Listenner de la vista tipo boton
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta2 = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(_2_SpinnerAdapterActivity.this, "Planeta seleccionado: " + strPlaneta
                                +"\nPlaneta seleccionado desde adapter: " + strPlaneta2,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No es necesario
            }
        });
    }

}