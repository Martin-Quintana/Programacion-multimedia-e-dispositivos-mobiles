package com.example.examen_final;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends ArrayAdapter {

    private Activity context;

    private ArrayList<String> nombres;

    public AdaptadorPersonalizado(Activity context, ArrayList<String> nombres) {
        super(context, R.layout.lista_adaptador, nombres);
        this.nombres = nombres;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflador = context.getLayoutInflater();
        View fila = inflador.inflate(R.layout.lista_adaptador, null);
        TextView nombre = (TextView) fila.findViewById(R.id.textoFila);
        nombre.setText(nombres.get(position).toString());
        return fila;
    }
}
