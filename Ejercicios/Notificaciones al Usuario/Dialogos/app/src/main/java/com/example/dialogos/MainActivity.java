package com.example.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   //end onCreate

    public void onClickBtn (View v){
        switch (v.getId()){
            case R.id.btnMensaje:
                dialogo_con_mensaje();
                break;
            case R.id.btn1:
                dialogo_con_1_boton();
                break;
            case R.id.btn2:
                dialogo_con_2_botones();
                break;
            case R.id.btn3:
                dialogo_con_3_botones();
                break;
        }//end switch
    }// end onClickBtn

    //metodo para crear un dialogo con un boton
    private void dialogo_con_mensaje(){
        //crea un objeto de la clase AlertDialog.Builder "ventana de dialogo"
        AlertDialog.Builder ventana = new AlertDialog.Builder(this); //this es el contexto
        ventana.setTitle("Atencion"); //titulo del dialogo
        ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
        ventana.setMessage("Este es un mensaje de aviso"); //mensaje del dialogo
        ventana.show(); //muestra el dialogo
    }//end dialogo_con_mensaje

    //metodo para crear un dialogo con un boton
    private void dialogo_con_1_boton() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this); //this es el contexto
        ventana.setTitle("Atencion"); //titulo del dialogo
        ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
        ventana.setMessage("Concede aviso"); //mensaje del dialogo
        //inhabillitar la posibilidad de cerrar el dialogo pulsando fuera de el
        ventana.setCancelable(false);
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.show(); //muestra el dialogo
    }

    //metodo para crear un dialogo con dos botones
    private void dialogo_con_2_botones() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this); //this es el contexto
        ventana.setTitle("Atencion"); //titulo del dialogo
        ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
        ventana.setMessage("Concede aviso"); //mensaje del dialogo
        //inhabillitar la posibilidad de cerrar el dialogo pulsando fuera de el
        ventana.setCancelable(false);
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                Toast.makeText(MainActivity.this, "Aceptar", Toast.LENGTH_SHORT).show();
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                Toast.makeText(MainActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.show(); //muestra el dialogo
    }

    //metodo para crear un dialogo con tres botones
    private void dialogo_con_3_botones() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this); //this es el contexto
        ventana.setTitle("Atencion"); //titulo del dialogo
        ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
        ventana.setMessage("Concede aviso"); //mensaje del dialogo
        //inhabillitar la posibilidad de cerrar el dialogo pulsando fuera de el
        ventana.setCancelable(false);
        ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                Toast.makeText(MainActivity.this, "Aceptar", Toast.LENGTH_SHORT).show();
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                Toast.makeText(MainActivity.this, "Cancelar", Toast.LENGTH_SHORT).show();
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.setNeutralButton("Despues", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo codigo a ejecutar cuando se pulse el boton
                //codigo a ejecutar cuando se pulse el boton
                Toast.makeText(MainActivity.this, "Despues", Toast.LENGTH_SHORT).show();
                dialog.cancel(); //cierra el dialogo
            }
        }); //boton del dialogo
        ventana.show(); //muestra el dialogo
    }
}