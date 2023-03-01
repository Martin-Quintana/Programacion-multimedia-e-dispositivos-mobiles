package com.example.notificaciones_barra_estado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnLanzarNotificacion(View view) {
        //1. Crea la notificacion
        Notification.Builder nb = new Notification.Builder(this);
        //2. Personalizar
        nb.setSmallIcon(android.R.drawable.star_on);
        nb.setTicker("Atención");
        nb.setContentTitle("Aviso de llamada");
        //nb.setContentText("Esto es el mensaje que queremos transmitir"); Texto de una sola linea
        nb.setStyle(new Notification.BigTextStyle().bigText("Esto es el mensaje que queremos transmitir" +
                                                            "\n Fernando Alonso le ha llamado" +
                                                            "\n Le ha dicho que es muy guapo" +
                                                            "\n Vamos a por la 33")); //Texto de varias lineas
        //Transformar el icono drawable en un bitmap
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), android.R.drawable.sym_call_incoming);
        nb.setLargeIcon(largeIcon);
        //3. Preparar la accion asociada a la notificacion
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        //4. Asociar la accion a la notificacion
        nb.setContentIntent(pendingIntent);
        // autoCancel: true -> la notificacion se cancela al pulsar sobre ella
        nb.setAutoCancel(true);
        //5. Lanzar el NotificationManager
        Notification notification = nb.build();
        android.app.NotificationManager nm = (android.app.NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1, notification);

    }
}