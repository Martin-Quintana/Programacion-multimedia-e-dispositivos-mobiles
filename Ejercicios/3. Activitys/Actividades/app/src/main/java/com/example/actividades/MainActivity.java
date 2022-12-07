package com.example.actividades;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_LLAMADA_CON_RESPUESTA_A5 = 1;

    private static final int CODIGO_LLAMADA_CON_RESPUESTA_A6 = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("ciclo","Ejecutando onCreate() de MainActivity");//Mensaje de log
    }//fin de onCreate()


    //Incluir metodos del ciclo de vida para ver que esta haciendo en cada momento
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo","Ejecutando onStart() de MainActivity");//Mensaje de log
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo","Ejecutando onStop() de MainActivity");//Mensaje de log
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy() de MainActivity");//Mensaje de log
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo","Ejecutando onResume() de MainActivity");//Mensaje de log
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo","Ejecutando onPause() de MainActivity");//Mensaje de log
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart() de MainActivity");//Mensaje de log
    }

    //listener de todos los botones
    public void onClickBtn(View view) {
        String strDatoEnviar;
        //El switch lo hacemos para poder manejar todos los botones
        switch (view.getId()){
            case R.id.btnLlamadaActivity2: {
                Intent intent = new Intent(this, Activity2.class);//El this significa en el propio lugar donde esta
                startActivity(intent);
                break;
            }
            case R.id.btnLlamadaActivity3: {
                strDatoEnviar = "ACT 1 envia mensaje suelto a la ACT 3";
                Intent intent = new Intent(this, Activity3.class);//El this significa en el propio lugar donde esta
                intent.putExtra("mensaje", strDatoEnviar);//Los datos van enviados con clave y valor, (clave = [mensaje], valor = [strDatoEnviar])
                startActivity(intent);
                break;
            }
            case R.id.btnLlamadaActivity4: {
                strDatoEnviar = "ACT 1 envia mensaje a la ACT 4 en un Bundle";
                Intent intent = new Intent(this, Activity4.class);//El this significa en el propio lugar donde esta
                //crear un objeto tipo Bundle para "empaquetar" los datos
                Bundle bundle = new Bundle();
                bundle.putString("mensaje_en_bundle", strDatoEnviar);//Los datos van enviados con clave y valor, (clave = [mensaje_en_bundle], valor = [strDatoEnviar])
                //cargo el paquete en el intent
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.btnLlamadaActivity5: {
                strDatoEnviar = "ACT 1 llama a la ACT 5 esperando respuesta";
                Intent intent = new Intent(this, Activity5.class);//El this significa en el propio lugar donde esta
                intent.putExtra("mensaje_con_respuesta", strDatoEnviar);//Los datos van enviados con clave y valor, (clave = [mensaje_con_respuesta], valor = [strDatoEnviar])
                //llamada esperando respuesta
                startActivityForResult(intent, CODIGO_LLAMADA_CON_RESPUESTA_A5); //Es Depreacated por eso esta tachado
                break;
            }
            case R.id.btnLlamadaActivity6: {
                Intent intent = new Intent(this, Activity6.class);
                startActivityForResult(intent, CODIGO_LLAMADA_CON_RESPUESTA_A6);
                break;
            }
        }
    }//Finalizacion del listener de los botones

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Saber en que momento del ciclo de vida se ejecuta esta callback
        Log.i("ciclo","Ejecutando onActivityResult() de MainActivity");//Mensaje de log

        TextView txtMensajeRecibido = findViewById(R.id.txtRespuestaRecibida);
        if(requestCode == CODIGO_LLAMADA_CON_RESPUESTA_A5) { // Respuesta de la Activity 5
            if(resultCode == RESULT_OK) { //Finalizado con la pulsacion del Boton
                String strDevuelto = data.getStringExtra("mensaje_devuelto");
                txtMensajeRecibido.setText(strDevuelto);
            } else { // No hemos recibido el OK
                txtMensajeRecibido.setText("EL USUARIO ABANDONO LA APP DESDE LA ACT5");
            }
        } else if (requestCode == CODIGO_LLAMADA_CON_RESPUESTA_A6){ // Respuesta de la Activity 6
            if(resultCode == RESULT_OK) { //Finalizado con la pulsacion del Boton
                txtMensajeRecibido.setText("NO ME HAN ENVIADO NADA PERO HAN FINALIZADO CON EL BOTON DE FIN");
            } else { // No hemos recibido el OK
                txtMensajeRecibido.setText("EL USUARIO ABANDONO LA APP DESDE LA ACT6");
            }
        }
    } //Finalida onActivityResult
}