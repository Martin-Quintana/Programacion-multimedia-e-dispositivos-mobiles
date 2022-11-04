package com.example.navegador_linear_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociar mi objeto java con la view declarada en el codigo XML del layout

        textView = findViewById(R.id.TextViewRespuesta);
    } //end onCreate

    public void onClickBtnSi(View view) {
        //todo: operaciones asociadas al click del boton SI
        //mensaje significativo en la textview final
        textView.setText(R.string.Si);

    }

    public void onClickBtn(View view) {
        if (view.getId() == R.id.btnNo) {
            textView.setText(R.string.No);
        } else if (view.getId() == R.id.btnTalVez) {
            textView.setText(R.string.Tal_Vez);
        }
    }

    //creacion de clase interna para implementar el escuchador
    private class Aux implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //gestionar pulsacion del btn1
            textView.setText("Boton 1 pulsado");
        }
    }
    //crear objeto de la clase auxiliar y asignarlo al botón 1
    Aux escuchador1 = new Aux();
    btn1.setOnClickListener(escuchador1);
}

