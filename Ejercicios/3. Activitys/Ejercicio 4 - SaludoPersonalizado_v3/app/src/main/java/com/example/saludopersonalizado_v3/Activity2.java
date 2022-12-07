package com.example.saludopersonalizado_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    RadioButton rbAdios, rbHastaPronto;
    CheckBox chkDespedida;
    LinearLayout layoutElegirDespedida;
    Button btnBtnFinalizar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        chkDespedida = findViewById(R.id.chkDespedida);

        rbAdios = findViewById(R.id.rbAdios);
        rbHastaPronto = findViewById(R.id.rbHastaPronto);
        chkDespedida = findViewById(R.id.chkDespedida);
        layoutElegirDespedida = findViewById(R.id.layoutElegirDespedida);
        btnBtnFinalizar = findViewById(R.id.btnBtnFinalizar);
        txtResultado = findViewById(R.id.txtResultado);

        chkDespedida.setOnCheckedChangeListener((compoundButton, b) -> chkDespedidaPerform(b));

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String strDatosRecibidos = bundle.getString("mensajePrincipal");
        TextView txtRecibida = findViewById(R.id.txtResultado);
        txtRecibida.setText(strDatosRecibidos);
    }

    private void chkDespedidaPerform(boolean checked) {
        if (checked) {
            layoutElegirDespedida.setVisibility(View.VISIBLE);
            setResult(RESULT_OK);
        } else {
            layoutElegirDespedida.setVisibility(View.GONE);
            setResult(RESULT_CANCELED);
        }
    }

    public void onClickBtnFinalizar(View view) {
        Intent intent;
        String strOut = null;

        if (rbAdios.isChecked()) {
            strOut = "Adios";
        } else if (rbHastaPronto.isChecked()) {
            strOut = "Hasta Pronto";
        }
        intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("despedida_personalizada", strOut);
        intent.putExtras(bundle);
        finish();
    }
}