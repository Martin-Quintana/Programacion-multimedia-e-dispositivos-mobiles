package com.example.saludopersonalizado_v3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_LLAMADA_ESPERAR_RESPUESTA_A2 = 1;

    EditText nombre, nacimiento;
    RadioButton rbSr, rbSra;
    Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.etNombre);
        nacimiento = findViewById(R.id.etNacimiento);
        rbSr = findViewById(R.id.rbSr);
        rbSra = findViewById(R.id.rbSra);
        btnSaludar = findViewById(R.id.btnSaludar);
    }

    private boolean editTextValidator() {
        if (nombre.getText().length() == 0) {
            Toast.makeText(this, "El campo nombre está vacío", Toast.LENGTH_SHORT).show();
            return false;
        } else if (nacimiento.getText().length() == 0) {
            Toast.makeText(this, "El campo fecha de nacimiento está vacío", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Integer.parseInt(nacimiento.getText().toString()) < 1900 || Integer.parseInt(nacimiento.getText().toString()) > 2022) {
            Toast.makeText(this, "El campo fecha no es válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void onClickBtnSaludar(View view) {
        Intent intent;

        String strOut = "Hola, %s %s.\nEres %s de edad.";
        if (editTextValidator()) {
            strOut = String.format(strOut,
                    ((rbSr.isChecked()) ? "Sr." : "Sra."),
                    nombre.getText().toString(),
                    ((2022 - Integer.parseInt(nacimiento.getText().toString()) < 18) ? "menor" : "mayor"));
        }

        intent = new Intent(this, Activity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("mensajePrincipal", strOut);
        intent.putExtras(bundle);
        startActivityForResult(intent, CODIGO_LLAMADA_ESPERAR_RESPUESTA_A2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView txtMensajeRecibido = findViewById(R.id.txtRespuesta);

        if (requestCode == CODIGO_LLAMADA_ESPERAR_RESPUESTA_A2) { // Respuesta de la Activity 2
            if (resultCode == RESULT_CANCELED) { // Finalizado sin chekear
                txtMensajeRecibido.setText("El usuario no quiso despedida");
            } else if (resultCode == RESULT_OK){
                String strDevuelto = data.getStringExtra("despedida_personalizada");
                txtMensajeRecibido.setText(strDevuelto);
            }
        }
    }

}