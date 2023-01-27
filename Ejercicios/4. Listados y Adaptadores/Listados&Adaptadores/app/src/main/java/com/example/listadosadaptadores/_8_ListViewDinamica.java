package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class _8_ListViewDinamica extends AppCompatActivity {

    // Estructura Dinamica
    private ArrayList<String> alPlanetas;
    private ArrayAdapter adaptador;
    private ListView lvPlanetas;
    private EditText etPlanetas;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8_list_view_dinamica);

        // Iniciador
        lvPlanetas = findViewById(R.id.lvPlanetas);
        etPlanetas = findViewById(R.id.etPlaneta);
        btnAdd = findViewById(R.id.btnAdd);
        alPlanetas = new ArrayList<>();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alPlanetas);
        lvPlanetas.setAdapter(adaptador);

        // Listener
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPlanetas.getText().toString().isEmpty()) {
                    //todo
                } else {
                    // Insertar
                    alPlanetas.add(etPlanetas.getText().toString());

                    // Refrescar el adaptador
                    adaptador.notifyDataSetChanged();

                    // Visualizar ListView
                    if (lvPlanetas.getVisibility() != View.VISIBLE) {
                        lvPlanetas.setVisibility(View.VISIBLE);
                    }

                    // Limpiar el et
                    etPlanetas.setText("");
                }
            }
        });

        // Listenner de la vista tipo boton
        lvPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String strPlaneta = lvPlanetas.getSelectedItem().toString();
                String strPlaneta2 = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No es necesario
            }
        });

    }

}