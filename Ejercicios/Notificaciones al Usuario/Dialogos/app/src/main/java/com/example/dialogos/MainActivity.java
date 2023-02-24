package com.example.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private static final int DIALOGO_CONMENSAJE = 0;
    private static final int DIALOGO_1_BTN = 1;
    private static final int DIALOGO_2_BTN = 2;
    private static final int DIALOGO_3_BTN = 3;
    private static final int DIALOGO_LISTA_DE_SELECCION = 4;
    private static final int DIALOGO_LISTA_DE_SELECCION_UNICA = 5;
    private static final int DIALOGO_LISTA_DE_SELECCION_MULTIPLE = 6;

    private int posicionColor;
    private View viewColor;

    //Declaraciones para el segundo procedimiento
    private AlertDialog.Builder ventana; //ventana de dialogo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewColor = findViewById(R.id.view);

    }   //end onCreate

    public void onClickBtn(View v) {
        switch (v.getId()) {
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
    private void dialogo_con_mensaje() {
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

    @SuppressWarnings("deprecation")
    public void onClickBtnBis(View view) {
        switch (view.getId()) {
            case R.id.btn4:
                /*** solicita lo que muestre ***/
                showDialog(DIALOGO_CONMENSAJE); //llama a onCreateDialog(0);
                break;
            case R.id.btn5:
                showDialog(DIALOGO_1_BTN); //llama a onCreateDialog(1
                break;
            case R.id.btn6:
                showDialog(DIALOGO_2_BTN); //llama a onCreateDialog(2);
                break;
            case R.id.btn7:
                showDialog(DIALOGO_3_BTN); //llama a onCreateDialog(3);
                break;
            case R.id.btn8:
                showDialog(DIALOGO_LISTA_DE_SELECCION); //llama a onCreateDialog(4);
                break;
            case R.id.btnSingleChoice:
                showDialog(DIALOGO_LISTA_DE_SELECCION_UNICA); //llama a onCreateDialog(5);
                break;
            case R.id.btnMultiChoice:
                showDialog(DIALOGO_LISTA_DE_SELECCION_MULTIPLE); //llama a onCreateDialog(6);
                break;

        }//end switch
    }// end onClickBtnBis

    //Sobreescritura del metodo onCreateDialog
    @Override
    protected Dialog onCreateDialog(int id) {
        String[] colores = getResources().getStringArray(R.array.colores);
        ventana = new AlertDialog.Builder(this);
        switch (id) {
            case DIALOGO_CONMENSAJE:
                ventana.setTitle("Atencion"); //titulo del dialogo
                ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
                ventana.setMessage("Este es un mensaje de aviso"); //mensaje del dialogo
                //ventana.show(); //muestra el dialogo
                break;
            case DIALOGO_1_BTN:
                ventana.setTitle("Atencion"); //titulo del dialogo
                ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
                ventana.setMessage("Este es un mensaje de aviso"); //mensaje del dialogo
                ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                //ventana.show(); //muestra el dialogo
                break;
            case DIALOGO_2_BTN:
                ventana.setTitle("Atencion"); //titulo del dialogo
                ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
                ventana.setMessage("Este es un mensaje de aviso"); //mensaje del dialogo
                ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                //ventana.show(); //muestra el dialogo
                break;
            case DIALOGO_3_BTN:
                ventana.setTitle("Atencion"); //titulo del dialogo
                ventana.setIcon(android.R.drawable.ic_dialog_alert); //icono del dialogo
                ventana.setMessage("Este es un mensaje de aviso"); //mensaje del dialogo
                ventana.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                ventana.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                ventana.setNeutralButton("Despues", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo
                //ventana.show(); //muestra el dialogo
                break;

            case DIALOGO_LISTA_DE_SELECCION:
                ventana.setTitle("Lista de Valores"); //titulo del dialogo
                ventana.setItems(colores, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton

                        Toast.makeText(MainActivity.this, "Opcion elegida " + colores[which], Toast.LENGTH_SHORT).show();
                    }
                }); //boton del dialogo
                //ventana.show(); //muestra el dialogo
                break;
            case DIALOGO_LISTA_DE_SELECCION_UNICA:
                ventana.setTitle("Lista de Valores seleccion unica"); //titulo del dialogo
                //ventana de dialogo single choice con boton de ok
                ventana.setSingleChoiceItems(colores, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        View view = findViewById(R.id.view);
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        //guarda la posicion del color dentro del array colores en la variable posicionColor
                        posicionColor = which;

                    }

                }); //boton del dialogo

                //En el boton de ok no puedes poner las opciones de seleccion unica se hace en el setSingleChoiceItems
                ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        //cambia el color de la view
                        viewColor.setBackgroundColor(getResources().getIntArray(R.array.colores_int)[posicionColor]);
                        removeDialog(DIALOGO_LISTA_DE_SELECCION_UNICA);
                        dialog.cancel(); //cierra el dialogo
                    } //boton del dialogo

                    //MANTIENE EL ESTADO PARA SUCESIVAS VISUALIZACIONES DE LA V.DIALOGO
                    //SI QUEREMOS "RESETEAR" DICHOS ESTADOS, HAY QUE LLAMAR AL METODO


                    //ventana.show(); //muestra el dialogo
                });
                break;

            case DIALOGO_LISTA_DE_SELECCION_MULTIPLE:
                ventana.setTitle("Lista de Valores seleccion multiple"); //titulo del dialogo
                ventana.setMultiChoiceItems(colores, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton

                        Toast.makeText(MainActivity.this, "Opcion elegida " + colores[which], Toast.LENGTH_SHORT).show();
                    }

                }); //boton del dialogo
                ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo codigo a ejecutar cuando se pulse el boton
                        //codigo a ejecutar cuando se pulse el boton
                        dialog.cancel(); //cierra el dialogo
                    }
                }); //boton del dialogo

                removeDialog(DIALOGO_LISTA_DE_SELECCION_MULTIPLE);
                //ventana.show(); //muestra el dialogo
                break;
        }//end switch
        return ventana.create(); //devuelve el dialogo
    }//end onCreateDialog


    //MANTIENE EL ESTADO PARA SUCESIVAS VISUALIZACIONES DE LA V.DIALOGO
    //Giro de pantalla guardando el estado
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("posicionColor", posicionColor);
    }

    //Giro de pantalla recuperando el estado
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        posicionColor = savedInstanceState.getInt("posicionColor");
        viewColor.setBackgroundColor(getResources().getIntArray(R.array.colores_int)[posicionColor]);
    }



}
