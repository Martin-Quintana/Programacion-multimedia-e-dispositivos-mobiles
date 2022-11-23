package com.example.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_LLAMADA_CON_RESPUESTA_A5 = 1;
    private static final int CODIGO_LLAMADA_CON_RESPUESTA_A6 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ciclo", "Activity 1 - Ejecutando onCreate()");//Mensaje de log
    }

    // Ciclo de vida
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo", "Activity 1 - Ejecutando onStart()");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo", "Activity 1 - Ejecutando onStop()");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo", "Activity 1 - Ejecutando onDestroy()");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo", "Activity 1 - Ejecutando onResume()");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo", "Activity 1 - Ejecutando onPause()");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo", "Activity 1 - Ejecutando onRestart()");//Mensaje de log
    }

    // Listener de todos los botones
    public void onClickBtn(View view) {
        Intent intent;
        String strDatoEnviado;

        switch (view.getId()) {
            case R.id.btnLlamadaActivity2:
                intent = new Intent(this, Activity2.class);
                startActivity(intent);
                break;

            case R.id.btnLlamadaActivity3:
                strDatoEnviado = "Act 1 envia mensaje suelto a la Act 3";
                intent = new Intent(this, Activity3.class);
                intent.putExtra("mensaje", strDatoEnviado);
                startActivity(intent);
                break;

            case R.id.btnLlamadaActivity4:
                strDatoEnviado = "Act 1 envia mensaje a la Act 4 en un Bundle";
                intent = new Intent(this, Activity4.class);

                // Crear un objeto de tipo bundle para empaquetar los datos
                Bundle bundle = new Bundle();
                bundle.putString("mensajeEnBundle", strDatoEnviado);

                //Cargo el paquete en el intent
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.btnLlamadaActivity5:
                strDatoEnviado = "Act 1 llama a Act 5 esperando respuesta";
                intent = new Intent(this, Activity5.class);
                intent.putExtra("mensaje_con_respuesta", strDatoEnviado);

                // Llamada esperando respuesta
                startActivityForResult(intent, CODIGO_LLAMADA_CON_RESPUESTA_A5);
                break;

            case R.id.btnLlamadaActivity6:
                intent = new Intent(this, Activity6.class);

                // Llamada esperando respuesta
                startActivityForResult(intent, CODIGO_LLAMADA_CON_RESPUESTA_A6);
                break;

            case R.id.btnLlamadaActivityOtraApp:
                intent = new Intent();
                intent.setClassName("com.example.saludopersonalizado_v3", "com.example.saludopersonalizado_v3.MainActivity");

                PackageManager pm = getPackageManager();
                List actividadesPosibles = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                if (actividadesPosibles.size() > 0) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Ninguna actividad puede realizar esta acción", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnLlamadaActivityOtraAppSistema:
                intent = new Intent();
                intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivity(intent);
                break;
        }
    } // End listener botones

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView txtMensajeRecibido = findViewById(R.id.txtRespuesta);

        // Saber en que momento del ciclo de vida se ejecuta esta callback
        Log.i("ciclo", "Activity 1 - Ejecutando onActivityResult()");//Mensaje de log

        if (requestCode == CODIGO_LLAMADA_CON_RESPUESTA_A5) { // Respuesta de la Activity 5
            if (resultCode == RESULT_OK) { // Finalizado con la pulsacion de boton
                String strDevuelto = data.getStringExtra("mensaje_devuelto");
                txtMensajeRecibido.setText(strDevuelto);
            } else { // No hemos recibido el OK
                txtMensajeRecibido.setText("El usuario abandono la aplicacion desde la act 5");
                Toast.makeText(this, "No se que ha pasado...", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CODIGO_LLAMADA_CON_RESPUESTA_A6) { // Respuesta de la Activity 6
            if (resultCode == RESULT_OK) { // Finalizado con la pulsacion de boton
                txtMensajeRecibido.setText("No me han enviado anda, pero han finalizado con el boton de fin");
            } else { // No hemos recibido el OK
                txtMensajeRecibido.setText("El usuario abandono la aplicacion desde la act 6");
            }
        }
    } // End onActivityResult

}