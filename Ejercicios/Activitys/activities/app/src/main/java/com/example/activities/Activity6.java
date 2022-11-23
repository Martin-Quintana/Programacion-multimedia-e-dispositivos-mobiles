package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    }

    public void onClickBtnFinalizar(View view) {
        // Operaciones varias
        setResult(RESULT_OK); // Enviar ok a la ACT 1
        finish(); // Obligar a que esta (ACT 6) se cierre
    }

}