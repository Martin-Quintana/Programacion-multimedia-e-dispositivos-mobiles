package com.example.listadosadaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.listadosadaptadores.listas._9_ListViewPersonalizadaDifImagenes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.btnSpinner:
                i = new Intent(this, _0_SpinnerActivity.class);
                startActivity(i);
                break;

            case R.id.btnSpinnerListenner:
                i = new Intent(this, _1_SpinnerListennerActivity.class);
                startActivity(i);
                break;

            case R.id.btnSpinnerAdaptador:
                i = new Intent(this, _2_SpinnerAdapterActivity.class);
                startActivity(i);
                break;

            case R.id.btnSpinnerAdaptadorRecursos:
                i = new Intent(this, _3_SpinnerAdaptadorRecursosActivity.class);
                startActivity(i);
                break;

            case R.id.btnSpinnerDinamico:
                i = new Intent(this, _4_SpinnerDinamicoActivity.class);
                startActivity(i);
                break;

            case R.id.btnList:
                i = new Intent(this, _5_ListViewActivity.class);
                startActivity(i);
                break;

            case R.id.btnListViewAdaptadorRecursos:
                i = new Intent(this, _6_ListViewAdapterActivity.class);
                startActivity(i);
                break;

            case R.id.btnListViewPersonalizadaSimple:
                i = new Intent(this, _7_ListViewPersonalizadaSimple.class);
                startActivity(i);
                break;

            case R.id.btnListViewDinamica:
                i = new Intent(this, _8_ListViewDinamica.class);
                startActivity(i);
                break;

            case R.id.btnListViewPersonalizadaDifImagenes:
                i = new Intent(this, _9_ListViewPersonalizadaDifImagenes.class);
                startActivity(i);
                break;
        }
    }
}