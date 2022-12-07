package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        String strDato = intent.getStringExtra("mensaje_con_respuesta");
        TextView txtDatoRecibido = findViewById(R.id.txtDatosRecibidos2);
        txtDatoRecibido.setText(strDato);

        Log.i("ciclo", "Activity 5 - Ejecutando onStart()");//Mensaje de log
    }

    // Ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo", "Activity 5 - Ejecutando onStart()");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo", "Activity 5 - Ejecutando onStop()");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo", "Activity 5 - Ejecutando onDestroy()");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo", "Activity 5 - Ejecutando onResume()");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo", "Activity 5 - Ejecutando onPause()");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo", "Activity 5 - Ejecutando onRestart()");//Mensaje de log
    }

    public void onClickBtnFinalizar(View view) {
        String datoRespuesta = "La actividad 5 responde HOLA a la actividad 1";
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putString("mensaje_devuelto", datoRespuesta);
        i.putExtras(b);

        // Mandar el rsultado a activity 1
        setResult(RESULT_OK, i);
        finish();
    }

}