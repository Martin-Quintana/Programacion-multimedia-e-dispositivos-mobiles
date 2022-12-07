package com.example.alarm_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.tpHora);
        datePicker = findViewById(R.id.dpFecha);
    }//Fin de onCreate()

    // Inicio del onClickBtn()
    public void onClickBtn(View view) {
        //Con el date picker cogemos el dia mes y anho
        int dia = datePicker.getDayOfMonth();
        int mes = datePicker.getMonth();
        int ano = datePicker.getYear();

        //Con el timePicker cogemos la hora y los minutos
        int hora = timePicker.getCurrentHour();
        int minuto = timePicker.getCurrentMinute();

        //Introducimos una toast
        Toast.makeText(this, dia + "/" + (mes + 1) + "/" + ano
                + "\n" + hora + ":" + minuto, Toast.LENGTH_SHORT).show();
    }
}



