package com.example.listados_adaptadores;

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

        //listenner de la vista tipo Spinner
        //=========================================================
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = spPlanetas.getSelectedItem().toString();
                String strPlaneta_v2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(_1_SpinnerListennerActivity.this,
                                "\n Planeta seleccionado: " + strPlaneta
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