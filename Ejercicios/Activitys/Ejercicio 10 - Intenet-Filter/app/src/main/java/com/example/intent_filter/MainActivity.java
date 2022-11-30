package com.example.intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrl = findViewById(R.id.etURL);
    }//Fin onCreate()

    public void btnVerWeb(View view) {
        Intent intent;
        //Lo pasamos a String
        String strUrl = etUrl.getText().toString();
        switch (view.getId()){
            case R.id.btnLlamadaExplicita: {
                intent = new Intent(this, LlamadaExplicitaActivity.class);
                intent.putExtra("string_url", strUrl);
                startActivity(intent);
                break;
            }
            case R.id.btnLlamadaImplicita: {
                //Le pedimos una accion a traves del intent
                intent = new Intent(Intent.ACTION_VIEW);
                //Parseamos el String es decir pasar de un String a Uri
                intent.setData(Uri.parse(strUrl));
                startActivity(intent);



                break;
            }
        }
    }
}