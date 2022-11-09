package com.example.saludo_personalizado;

import static com.example.saludo_personalizado.R.id.Saludar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private final TextView textView = findViewById(Saludar);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSaludar(View view) {
        String edad = "Hola";

        if (R.id.nacimiento > 2004){
            edad = "Eres mayor de edad";
        } else {
            edad = "Eres menor de edad";
        }

        textView.setText("Hola, " + R.id.nombre + edad);
    }
}