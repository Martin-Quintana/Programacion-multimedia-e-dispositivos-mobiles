package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class _0_SpinnerActivity extends AppCompatActivity {

    private Button btnEleccion;
    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_0_spinner);

        btnEleccion = findViewById(R.id.btnEleccion);
        spPlanetas = findViewById(R.id.spPlanetas);

        // Listenner del boton
        btnEleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String planeta = spPlanetas.getSelectedItem().toString();
                long longPosition = spPlanetas.getSelectedItemId();
                int intPosition = spPlanetas.getSelectedItemPosition();
                Toast.makeText(_0_SpinnerActivity.this, "Planeta: " + planeta + " Posicion_long: " + longPosition + " Posicion_int: " + intPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }
}