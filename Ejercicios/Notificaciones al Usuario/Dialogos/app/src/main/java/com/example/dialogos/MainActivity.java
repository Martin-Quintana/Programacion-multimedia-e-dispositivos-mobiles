package com.example.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn (View v){
        switch (v.getId()){
            case R.id.btnMensaje:
                //dialogo_con_mensaje();
                break;
            case R.id.btn1:
                //dialogo_con_1_boton();
                break;
            case R.id.btn2:
                //dialogo_con_2_botones();
                break;
            case R.id.btn3:
                //dialogo_con_3_botones();
                break;
        }//end switch
    }// end onClickBtn


}