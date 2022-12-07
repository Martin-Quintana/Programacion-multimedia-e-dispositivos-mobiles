package com.example.intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class LlamadaImplicitaActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamada_implicita);
        webView = findViewById(R.id.webViewImplicita);
        Intent intent = getIntent();
        Uri uriRecibida = intent.getData();
        //Necesitamos convertir la UriRecibida a String porque necesitamos un String
        //Para cargar la Url
        webView.loadUrl(uriRecibida.toString());
    }
}