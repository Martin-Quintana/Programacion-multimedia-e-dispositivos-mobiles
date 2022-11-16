package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        }
    }
}