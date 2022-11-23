package com.example.intentsimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {
        Intent i = new Intent();

        switch (view.getId()) {
            case R.id.btnContactos:
                break;

            case R.id.btnDial:
                i.setAction(Intent.ACTION_DIAL); // No necesito datos
                startActivity(i);
                break;

            case R.id.btnDialConNum:
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:(+34)622004018"));
                startActivity(i);
                break;
        }
    }
}