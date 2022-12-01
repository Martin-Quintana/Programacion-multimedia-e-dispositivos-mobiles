package com.example.cuenta_clicks_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //Atributo contador para que cuente la cantidad de veces que se pulse el boton
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociar mi objeto java con la view declarada en el codigo XML de layout
        textView = findViewById(R.id.contador);
        Log.i("ciclo","Ejecutando onCreate()");//Mensaje de log
    } //end onCreate

    //Metodo onClick (cuando pulsa el boton) va sumando de uno en uno al contador
    public void onClickPulsa(View view) {
        //todo: opereaciones asociadas al click del boton PULSA
        //mensaje significativo en la textview final
        contador++;
        textView.setText("Has pulsado " + contador + " veces");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador", contador);
        Log.i("ciclo","Ejecutando onSaveInstanceState()");//Mensaje de log
    }

    //Forma 1:
    //METODO DE RECUPERACION
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
        Log.i("ciclo","Ejecutando onRestoreInstanceState()");//Mensaje de log
    }

    //Forma 2:
    //


    //Metodos del Ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart()");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop()");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy()");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume()");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause()");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart()");//Mensaje de log
    }

    /*
    //metodo onClick (cuando pulsa el boton) restaura el contador a cero
    public void onClickFinalizar(View view) {
        //todo: opereaciones asociadas al click del boton FINALIZAR
        //mensaje significativo en la textview final
        contador = 0;
        textView.setText("Has pulsado " + contador + " veces");
    }*/
}