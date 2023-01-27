package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class _1_SpinnerListennerActivity extends AppCompatActivity {

    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_spinner_listenner);

        spPlanetas = findViewById(R.id.spPlanetas);

        // Listenner de la vista tipo boton
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta2 = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(_1_SpinnerListennerActivity.this, "Planeta seleccionado: " + strPlaneta
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