package com.example.lanzarsettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSettings = findViewById(R.id.btnSettings);
    }

    public void onClickBtnSettings(View view) {
        Intent intent;
        intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings");
        startActivity(intent);
    }

}