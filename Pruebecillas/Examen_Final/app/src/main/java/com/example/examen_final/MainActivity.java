package com.example.examen_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.Manifest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//RECUERDA PULSAR LARGO EN LA IMAGENT PARA QUE APAREZCA EL MENU CONTEXTUAL

    private static final String databaseName = "Compuestos.db";
    private static final int databaseVersion = 1;
    private SQLiteDatabase sqLiteDatabase;

    private final int NOTIFICACIONALERTAID = 9;

    SharedPreferences.Editor editor;
    NotificationManager nm;
    Notification notificacion;

    private ArrayList<String> nombres = new ArrayList<>();

    LinearLayout layoutBienvenida;
    LinearLayout layoutEjecucion;
    ImageView imagenPrincipal;
    ListView listaCompuestos;

    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Base de datos
        SQLiteOpenHelper sqLiteOpenHelper = new SQLiteOpenHelper(this, databaseName, null, databaseVersion);
        sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();

        //Enlazamos las variables con los elementos del layout
        imagenPrincipal = findViewById(R.id.imagenPrincipal);
        layoutBienvenida = findViewById(R.id.layoutBienvenida);
        layoutEjecucion = findViewById(R.id.layoutEjecucion);
        listaCompuestos = findViewById(R.id.listaCompuestos);

        //Registramos el menu contextual
        registerForContextMenu(imagenPrincipal);

        //Creo listener para la lista
        listaCompuestos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = nombres.get(position);
                Intent intent = new Intent(MainActivity.this, Selects.class);
                intent.putExtra("nombre", nombres.get(position));
                bundle.putString("seleccion", seleccion);
                startActivityForResult(intent, 1);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubienvenida, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Acerca de");
                builder.setMessage("Aplicación creada por: \n" +
                        "Martin Quintana \n");
                builder.setIcon(R.drawable.flask);
                builder.show();
                break;
            case R.id.item2:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    String[] permisos = {Manifest.permission.CALL_PHONE};
                    ActivityCompat.requestPermissions(this,permisos,0);
                } else {
                    Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986110011"));
                    startActivity(i);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucontextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NotNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item3:
                layoutBienvenida.setVisibility(View.GONE);
                layoutEjecucion.setVisibility(View.VISIBLE);

                //Obtenemos los valores de la base de datos y los mostramos en el layout
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM compuestos;", null);

                if (cursor.moveToFirst()) {
                    do {
                        nombres.add(cursor.getString(0));
                        System.out.println(cursor.getString(0));
                    } while (cursor.moveToNext());
                    AdaptadorPersonalizado adaptadorPersonalizado = new AdaptadorPersonalizado(this, nombres);
                    listaCompuestos.setAdapter(adaptadorPersonalizado);
                } else {
                    System.out.println("Base de datos vacia");
                }

                break;
            case R.id.item4:
                finish();
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1) {
            Bundle b1 = data.getExtras();
            if (requestCode == RESULT_CANCELED) {
                editor.putInt("aciertos", b1.getInt("aciertos"));
                editor.commit();
                finish();
            } else {

                if (b1.getInt("fallos", 0) > 2) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setTicker("Aviso");
                    builder.setContentTitle("Muchos fallos");
                    builder.setContentText("Has fallado demasiadas veces");
                    builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.flask));

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                    builder.setContentIntent(pendingIntent);
                    nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificacion = builder.build();
                    builder.setAutoCancel(true);
                    nm.notify(NOTIFICACIONALERTAID, notificacion);


                } else {
                    bundle.putInt("fallos", b1.getInt("fallos"));
                }
                System.out.println(b1.getInt("fallos"));
            }
        }

    }


}
