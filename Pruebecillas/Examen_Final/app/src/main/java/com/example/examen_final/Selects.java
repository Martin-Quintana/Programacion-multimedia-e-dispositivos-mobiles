package com.example.examen_final;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Selects extends AppCompatActivity {

    SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(this, "Compuestos.db", null, 1);

    EditText etinput;
    SQLiteDatabase sqLiteDatabase;

    LinearLayout layoutEntrada;
    LinearLayout layoutSalida;

    RadioGroup radioGroup;
    RadioButton radioButtonSi;
    RadioButton radioButtonNo;
    Button btnTest;
    Button btnSiguiente;
    String formula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selects);

        layoutEntrada = findViewById(R.id.layoutEntrada);
        layoutSalida = findViewById(R.id.layoutSalida);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonSi = findViewById(R.id.radioSi);
        radioButtonNo = findViewById(R.id.radioNo);
        btnSiguiente = findViewById(R.id.btnContinuar);

        layoutEntrada.setVisibility(View.VISIBLE);
        layoutSalida.setVisibility(View.GONE);


        final Bundle b = getIntent().getExtras();
        final String codigo = b.getString("seleccion");
        etinput = findViewById(R.id.etinput);

        //Recogemos el intent
        Intent intent = getIntent();
        //Recogemos el bundle
        Bundle bundle = intent.getExtras();
        //Recogemos el valor del bundle
        String valor = bundle.getString("nombre");
        //Lo mostramos en el EditText
        etinput.setHint(valor);

        btnTest = findViewById(R.id.btnTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etinput.getText().toString().isEmpty()) {
                    Toast.makeText(Selects.this, "Faltan datos", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();
                    //Creamos la consulta
                    String sql = "SELECT formula FROM Compuestos WHERE nombre = '" + valor + "'";
                    Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
                    if (cursor.moveToFirst()) {
                        formula = cursor.getString(0).toString();
                        //Si es igual volvemos a la lista de compuestos
                        layoutEntrada.setVisibility(View.GONE);
                        layoutSalida.setVisibility(View.VISIBLE);

                    }
                    if (etinput.getText().toString().equalsIgnoreCase(formula)) {
                        Toast.makeText(Selects.this, "Correcto", Toast.LENGTH_SHORT).show();
                        bundle.putInt("aciertos", bundle.getInt("aciertos") + 1);
                    } else {
                        Toast.makeText(Selects.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                        bundle.putInt("fallos", bundle.getInt("fallos") + 1);
                    }
                }
            }

        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == radioButtonSi.getId()) {
                    //Si es igual volvemos a la lista de compuestos
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    intent.putExtras(bundle);
                    finish();
                } else {
                    Intent intent = new Intent();
                    setResult(RESULT_CANCELED, intent);
                    intent.putExtras(bundle);
                    finish();
                    Intent intent2 = new Intent(Selects.this, MainActivity.class);
                    startActivity(intent2);
                }
            }
        });
    }
}