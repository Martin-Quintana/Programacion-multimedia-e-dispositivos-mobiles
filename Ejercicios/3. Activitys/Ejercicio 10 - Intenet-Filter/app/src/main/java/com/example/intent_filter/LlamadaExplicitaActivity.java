package com.example.intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LlamadaExplicitaActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_explicita);
        webView = findViewById(R.id.webViewExplicita);
        Intent intent = getIntent();
        String urlRecibida = intent.getStringExtra("string_url");
        //Habilitamos JavaScript pues de lo contrario, muchas web cargaran mal
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //clase WebView -- metodo loadUrl(string)
        webView.loadUrl(urlRecibida);

    }//Fin on Create()
}