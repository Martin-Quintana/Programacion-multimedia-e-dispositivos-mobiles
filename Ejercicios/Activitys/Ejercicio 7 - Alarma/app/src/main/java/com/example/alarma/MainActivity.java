package com.example.alarma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//Fin de onCreate()

    public void onClickBtn(View view) {
        //Contruimos el intent de manera que se inicie la alarma
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Hora de levantarse!!!!!!!!!");
        intent.putExtra(AlarmClock.EXTRA_HOUR, 8);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 7);
        intent.putExtra(AlarmClock.EXTRA_RINGTONE, "Rooster Alarm");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}