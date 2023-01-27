package com.example.listadosadaptadores.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listadosadaptadores.R;
import com.example.listadosadaptadores.adapter.CustomAdapter1;

public class _9_ListViewPersonalizadaDifImagenes extends AppCompatActivity {

    private ListView lvPlanetas;
    private String[] arrayPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9_list_view_personalizada_dif_imagenes);

        lvPlanetas = findViewById(R.id.lvPlanetas);
        arrayPlanetas = getResources().getStringArray(R.array.planetas);
        int[] arrayIdFotos={R.drawable.mercurio,
                R.drawable.venus,
                R.drawable.tierra,
                R.drawable.marte,
                R.drawable.jupiter,
                R.drawable.saturno,
                R.drawable.urano,
                R.drawable.neptuno};

    //Crear un adaptador personalizado --> clase java extends ArrayAdapter
        CustomAdapter1 adaptador = new CustomAdapter1(this,
                R.layout._9_fila_listview,
                arrayPlanetas,
                arrayIdFotos);

    // Asignar adaptador a la lista
    lvPlanetas.setAdapter(adaptador);

    // Listener de la lista
    //    lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    //        @Override
    //        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    //            Toast.makeText(_9_ListViewPersonalizadaDifImagenes.this,
    //                    "Planeta: " + adapterView.getItemAtPosition()).show();
    //        }
    //    });

    }
}