package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    } //Fin onCreate()

    public void onClickBtnFinalizar(View view) {
        // Operaciones varias
        setResult(RESULT_OK);//Enviar OK a la actividad que me llamo que es la MainActivity
        finish();//Obligar a que act6 se cierre
    }
}