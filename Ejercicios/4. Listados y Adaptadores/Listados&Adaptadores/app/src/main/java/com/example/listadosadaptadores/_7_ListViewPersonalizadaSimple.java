package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ListIterator;

public class _7_ListViewPersonalizadaSimple extends AppCompatActivity {

    private ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7_list_view_personalizada_simple);

        lvPlanetas = findViewById(R.id.lvPlanetas);

        // Crear adaptador personalizado
        ArrayAdapter adaptador = new ArrayAdapter<String>(this, R.layout.fila_simple, R.id.tvPlaneta, getResources().getStringArray(R.array.planetas));

        // Asignar el adaptador a lv
        lvPlanetas.setAdapter(adaptador);
    }
}