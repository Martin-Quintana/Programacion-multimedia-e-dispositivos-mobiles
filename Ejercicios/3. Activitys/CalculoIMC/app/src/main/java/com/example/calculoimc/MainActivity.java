package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    LinearLayout LlFoto;
    LinearLayout LlMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        LlFoto = findViewById(R.id.Foto);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick (View v) {
                longclick();
                return true;
            }
        });

    }




    public  void longclick() {

        imageView.setVisibility(LlFoto.INVISIBLE);

    }
}