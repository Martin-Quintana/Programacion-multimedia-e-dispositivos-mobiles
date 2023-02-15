package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class AuxiliarActivity extends AppCompatActivity {



    //Este es el metodo que se utiliza para llamar al Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflado del recurso de tipo menu que tenemos en XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }//Fin onCreateOptionsMenu(){}



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

    }//Fin AuxiliarActivity{
}//Fin AuxiliarActivity{}
