package com.example.shared_references;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void onClickBtnPreferencias(View view) {
        switch (view.getId()) {
            case R.id.btnGuardar:
                //todo Guardar datos
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("nombre", "Fernando");
                editor.putString("email", "fernandoalonso33@gmail.com");
                editor.apply();
                Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRecuperar:
                //todo Recuperar datos
                String strNombre = preferencias.getString("nombre", "NO HAY NOMBRE GUARDADO");
                String strEmail = preferencias.getString("email", "NO HAY EMAIL GUARDADO");

                Toast.makeText(this, "Nombre: " + strNombre + "\nEmail: " + strEmail, Toast.LENGTH_SHORT).show();
                break;

        }
    }
}