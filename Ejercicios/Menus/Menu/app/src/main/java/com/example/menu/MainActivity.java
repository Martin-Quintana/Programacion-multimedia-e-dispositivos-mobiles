package com.example.menu;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello = findViewById(R.id.tvHello);
        registerForContextMenu(tvHello);
    } //Fin onCreate(){}


    //Para que llamar y hacer el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual_options_menu, menu);
    }

    //Este es el metodo que se utiliza para llamar al Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflado del recurso de tipo menu que tenemos en XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        //Se cambia potque realmente es una respuesta negativa o positiva
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    //metodo (evento) lanzado por el sistema cuando se pulsa un item del menu de opciones

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1: {
                Toast.makeText(this, "Pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.item2: {
                Toast.makeText(this, "Pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.item3: {
                Toast.makeText(this, "Pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}