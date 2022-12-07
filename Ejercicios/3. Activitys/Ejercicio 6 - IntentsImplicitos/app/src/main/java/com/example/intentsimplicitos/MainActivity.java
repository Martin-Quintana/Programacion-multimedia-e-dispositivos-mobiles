package com.example.intentsimplicitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int LLAMADA_TELEFONO = 1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = new Intent();
    }

    public void onClickBtn(View view) {
        //Intent i = new Intent();

        switch (view.getId()) {
            case R.id.btnContactos:
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("content://contacts/people/"));
                startActivity(i);
                break;

            case R.id.btnDial:
                i.setAction(Intent.ACTION_DIAL); // No necesito datos
                startActivity(i);
                break;

            case R.id.btnDialConNum:
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:(+34)644260673"));
                startActivity(i);
                break;

            // Necesita permisos especiales en el manifest
            case R.id.btnLlamadaDirecta:
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:(+34)622004018"));
                // Tenemos permiso concedido???
                // Testear la version de API
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(i);
                    } else { // No existe concesion de permiso todavia --> Solicitarlo
                        requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);
                    }
                } else { // Version anterior a la API 23
                    startActivity(i);
                }
                break;

            // Librerias para compatibilidad
            case R.id.btnLlamadaDirecta2:
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:(+34)622004018"));
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(i);
                } else { // No existe concesion de permiso todavia --> Solicitarlo
                    ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONO);
                }
                break;

            case R.id.btnAbrirNavegador:
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.edu.xunta.gal/portal"));
                startActivity(i);
                break;

            case R.id.btnMostrarMapa:
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:42.25,-8.68"));
                startActivity(i);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LLAMADA_TELEFONO) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "El ususario SI concedio el permiso solicitado", Toast.LENGTH_SHORT).show();
                startActivity(i);
            } else {
                Toast.makeText(this, "El ususario NO concedio el permiso solicitado", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Todo en caso de respuesta a otra solicitud
        }
    }

}












