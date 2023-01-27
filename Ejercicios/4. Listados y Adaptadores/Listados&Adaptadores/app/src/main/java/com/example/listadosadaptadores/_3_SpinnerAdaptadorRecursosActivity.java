package com.example.listadosadaptadores;

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

        // Crear el adaptador -- los datos se obtienen desde un recurso
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planetas, android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador a la vista
        spPlanetas.setAdapter(adapter);

        // Listenner de la vista tipo boton
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta2 = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(_3_SpinnerAdaptadorRecursosActivity.this, "Planeta seleccionado: " + strPlaneta
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