package com.example.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Ejecutando onCreate()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onCreate()");//Mensaje de log
    }//fin de onCreate()

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Ejecutando onStart()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onStart()");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Ejecutando onStop()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onStop()");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Ejecutando onDestroy()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onDestroy()");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Ejecutando onResume()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onResume()");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Ejecutando onPause()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onPause()");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"Ejecutando onRestart()", Toast.LENGTH_SHORT).show(); //Mensaje como Toast por pantalla
        Log.i("ciclo","Ejecutando onRestart()");//Mensaje de log
    }

    //Accion del boton finalizar
    public void onClickBtn(View view) {
        finish();
    }
}