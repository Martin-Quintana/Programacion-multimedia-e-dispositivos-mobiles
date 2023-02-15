package com.example.menu;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AuxiliarActivity {

    TextView tvHello;
    ImageView ivHoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Para el menu de contextual 2
        tvHello = findViewById(R.id.tvHello);
        registerForContextMenu(tvHello);
        //Para el menu contextual
        ivHoja = findViewById(R.id.ivHoja);
        registerForContextMenu(ivHoja);
    }//Fin onCreate(){}

    public void onClickBtn(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }//Fin onClickBtn(){}




    //Click largo para verlo
    //Para que llamar y hacer el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if (v.getId() == R.id.ivHoja) {
            inflater.inflate(R.menu.contextual_options_menu, menu);
        } else if (v.getId() == R.id.tvHello) {
            inflater.inflate(R.menu.contextual_options_menu_2, menu);
        }
    }



    //metodo (evento) lanzado por el sistema cuando se pulsa un item del menu contextual

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ctx_item1: {
                Toast.makeText(this, "Pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.ctx_item2: {
                Toast.makeText(this, "Pulsado " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onContextItemSelected(item);//En los swich ponemos un return default
        }
    }  //Fin onContextItemSelected(){}



}
