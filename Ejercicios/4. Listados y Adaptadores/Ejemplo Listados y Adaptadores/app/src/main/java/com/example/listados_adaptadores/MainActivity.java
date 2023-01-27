package com.example.listados_adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickBtn(View view) {
        //Intent i = new Intent();

        switch (view.getId()) {
            case R.id.btnSpinner: {
                Intent intent = new Intent(this, _0_SpinnerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnSpinnerListenner: {
                Intent intent = new Intent(this, _1_SpinnerListennerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnSpinnerConAdaptador: {
                Intent intent = new Intent(this, _2_SpinnerAdapterActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnSpinnerConRecurso: {
                Intent intent = new Intent(this, _3_SpinnerAdaptadorRecursosActivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.btnSpinnerDinamico: {
                Intent intent = new Intent(this, _4_SpinnerDinamicoActivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.btnListView: {
                Intent intent = new Intent(this, _5_ListViewActivity.class);
                startActivity(intent);
                break;
            }
            case  R.id.btnLisViewAdapter: {
                Intent intent = new Intent(this, _6_ListViewAdapter.class);
                startActivity(intent);
                break;
            }


        }
    }
}