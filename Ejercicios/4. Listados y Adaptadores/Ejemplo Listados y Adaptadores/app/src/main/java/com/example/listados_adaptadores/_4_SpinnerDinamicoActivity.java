package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class _4_SpinnerDinamicoActivity extends AppCompatActivity {

    //Estructura dinamica
    private ArrayList<String> alPlanetas;
    private ArrayAdapter adaptador;
    private Spinner spPlanetas;
    private EditText etPlanetas;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_spinner_dinamico);
        //Inicializar
        spPlanetas = findViewById(R.id.spPlanetas);
        etPlanetas = findViewById(R.id.etPlaneta);
        btnAdd = findViewById(R.id.btnAdd);
        alPlanetas = new ArrayList<String>();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, alPlanetas);
        spPlanetas.setAdapter(adaptador);
        //listener

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //testear valor
                if (etPlanetas.getText().toString().isEmpty()) {
                    //todo
                } else {
                    //insertar
                    alPlanetas.add(etPlanetas.getText().toString());
                    //refrescamos el adaptador
                    adaptador.notifyDataSetChanged();
                    //visualizar el spinner UNA SOLA VEZ
                    if (spPlanetas.getVisibility() != View.VISIBLE) {
                        spPlanetas.setVisibility(View.VISIBLE);
                    }
                    //limpiar el et
                    etPlanetas.setText("");
                }
            }
        });

        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta_v2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(_4_SpinnerDinamicoActivity.this,
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