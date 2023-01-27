package com.example.listadosadaptadores.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listadosadaptadores.R;

public class CustomAdapter1 extends ArrayAdapter {

    private Activity context;
    private String[] arrayPlanetas;
    private int[] arrayIdFotos;

    public CustomAdapter1(@NonNull Activity context,
                          int miLayoutPersonalizado,
                          String[] arrayPlanetas,
                          int[] arrayIdFotos) {

        // Llamada al constructor defectivo de 3 parametros
        super(context, miLayoutPersonalizado, arrayPlanetas);
        this.context = context;
        this.arrayPlanetas = arrayPlanetas;
        this.arrayIdFotos = arrayIdFotos;
    }

    // Gestionar las operaciones especificas de mi app
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Crear instancia del objeto inflador
        LayoutInflater layoutInflater = context.getLayoutInflater();
        // Aplicar el metodo de inflado sobre el objeto inflador
        View fila = layoutInflater.inflate(R.layout._9_fila_listview, null);
        // Capturamos los ids de cada componente de mi layout personalizado
        TextView tvPlaneta = fila.findViewById(R.id.tvPlaneta);
        ImageView imgPlaneta = fila.findViewById(R.id.imgPlaneta);
        // Insertar en cada componente el valor correspondiente de cada array
        tvPlaneta.setText(arrayPlanetas[position]);
        imgPlaneta.setImageResource(arrayIdFotos[position]);
        return fila;
    }

}
