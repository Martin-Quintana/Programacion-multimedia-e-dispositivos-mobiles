package com.example.cuenta_clicks_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //Atributo contador para que cuente la cantidad de veces que se pulse el boton
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        //asociar mi objeto java con la view declarada en el codigo XML de layout
        textView = findViewById(R.id.contador);
    } //end onCreate

    //Metodo onClick (cuando pulsa el boton) va sumando de uno en uno al contador
    public void onClickPulsa(View view) {
        //todo: opereaciones asociadas al click del boton PULSA
        //mensaje significativo en la textview final
        contador++;
        textView.setText("Has pulsado " + contador + " veces");
    }

    //metodo onClick (cuando pulsa el boton) restaura el contador a cero
    public void onClickFinalizar(View view) {
        //todo: opereaciones asociadas al click del boton FINALIZAR
        //mensaje significativo en la textview final
        contador = 0;
        textView.setText("Has pulsado " + contador + " veces");
    }
}