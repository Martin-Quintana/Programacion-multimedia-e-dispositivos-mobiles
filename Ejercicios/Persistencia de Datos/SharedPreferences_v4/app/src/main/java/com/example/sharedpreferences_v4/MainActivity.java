package com.example.sharedpreferences_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtSelecciones;
    private SharedPreferences pref;
    private SharedPreferences.Editor editorPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        txtSelecciones=findViewById(R.id.txtSelecciones);
        pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        editorPref = pref.edit();
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnPreferencias:
                Intent i = new Intent(this, PreferencesActivity.class);
                startActivity(i);
                break;
            case R.id.btnObtenerPreferencias:
                boolean opcion1 = pref.getBoolean("opcion1", false);//checkbox
                String opcion2 = pref.getString("opcion2", "nada");//editText
                String opcion3 = pref.getString("opcion3", "ninguno");//lista seleccion simple
                boolean opcion4 = pref.getBoolean("opcion4", false);//switch,
                String opcion5_ringtone = pref.getString("opcion5_ringtone", "none");//ringtone
                int opcion6_seekbar = pref.getInt("opcion6_seekbar", 5);//seekbar
                String mensaje="Valores elegidos:  " +
                                    "\nCheckbox: " + opcion1 +
                                    "\nNombre: " + opcion2 +
                                    "\nColor: " + opcion3 +
                                    "\nSwitch: "+ opcion4 +
                                    "\nRingtone: " + opcion5_ringtone +
                                    "\nSeekBar: " + opcion6_seekbar;
                txtSelecciones.setText(mensaje);
                break;
            case R.id.btnResetPreferencias:
                editorPref.clear();
                editorPref.apply();
                break;
            default:
                break;
        }
    }
}