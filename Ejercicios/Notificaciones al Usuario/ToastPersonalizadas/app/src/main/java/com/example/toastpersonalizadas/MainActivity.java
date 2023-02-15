package com.example.toastpersonalizadas;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } //Fin onCreate()

    public void onClickBtn(View view) {
        switch(view.getId()){
            case R.id.btnToastDefectiva:
                Toast.makeText(MainActivity.this, "Toast defectiva", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnToastGravity:
                Toast t2=Toast.makeText(MainActivity.this, "Toast en otra posición", Toast.LENGTH_SHORT);
                //parametros: una cte. Gravity, desplazamiento en x, y desplazamiento en y
                //Desplazar a dcha-->aumentar el valor x
                //Desplazar hacia abajo-->aumentar el valor y
                //t2.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT, 30,0);
                t2.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT, 0, 0); //Desplazar a dcha
                t2.show(); //Mostrar el Toast
                break;
            case R.id.btnToastPersonalizada:
                LinearLayout llToast=findViewById(R.id.llLayout); //Obtener el LinearLayout
                LayoutInflater inflater = getLayoutInflater(); //Obtener el inflador
                View v = inflater.inflate(R.layout.mitoast, llToast); //Inflar el layout
                TextView textoDeToast = v.findViewById(R.id.txtMensaje); //Obtener el TextView
                textoDeToast.setText("Toast personalizada"); //Cambiar el texto
                Toast t3 = new Toast(this); //Contexto
                t3.setDuration(Toast.LENGTH_SHORT); //Duración corta
                t3.setGravity(Gravity.CENTER_HORIZONTAL,0,-100); //Desplazar hacia arriba
                t3.setView(v);
                t3.show();
                break;

        }
    } //Fin onClickBtn()
}

