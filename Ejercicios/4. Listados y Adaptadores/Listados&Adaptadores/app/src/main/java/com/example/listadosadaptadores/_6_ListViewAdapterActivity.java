package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class _6_ListViewAdapterActivity extends AppCompatActivity {

    private ListView lvPlanetas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6_list_view_adapter);

        lvPlanetas = findViewById(R.id.lvPlanetas);

        // Crear el adaptador -- los datos se obtienen desde un recurso
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource
                (this, R.array.planetas, android.R.layout.simple_list_item_1);

        // Asignar el adaptador a la vista
        lvPlanetas.setAdapter(adaptador);

        // Listenner de la lista
        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String planetaSeleccionado = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(_6_ListViewAdapterActivity.this, "Planeta: " + planetaSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}