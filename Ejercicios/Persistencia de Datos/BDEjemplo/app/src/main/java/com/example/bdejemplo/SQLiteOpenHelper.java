package com.example.bdejemplo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

/* clase auxiliar para facilitar la creación/actualización de nuestra base de datos
* sus métodos getWritableDatabase() y getReadableDatabase() nos permitirán abrirla posteriormente
* en el modo que más se adapte a nuestras necesidades */
public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private String strCreateTable ="CREATE TABLE alumnos (codigo INT PRIMARY KEY, nombre TEXT)";
    Context context;
    //constructor
    public SQLiteOpenHelper(@Nullable Context context,
                            @Nullable String nameOfDatabase,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, nameOfDatabase, factory, version);
        this.context=context;
    }

    /* métodos abstractos de la clase SQLiteOpenHelper que debemos sobreescribir
       Ya nos lo solicita el IDE con su generador de código, si queréis probarlo */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /* operaciones de creacion de la base de datos. En este caso lo hacemos mediante el método genérico
        execSQL() que nos permite escribir la sentencia SQL de forma directa (excepto en sentencias de
        devolución de datos) */
        sqLiteDatabase.execSQL(strCreateTable);

        /* si nuestra BD tiene datos por inicio, podríamos insertarlos aquí.
           El método onCreate() sólo se ejecuta si la base de datos no existe previamente.

           En este caso también lo hice con inyección directa para que se vea la posibilidad de esecSQL()
           aunque no es la forma más recomendable...
         */
        try {
            sqLiteDatabase.execSQL("INSERT INTO alumnos (codigo, nombre) VALUES (1, 'Manuel Rodríguez')");
            sqLiteDatabase.execSQL("INSERT INTO alumnos VALUES (2, 'María Gómez')");
        }catch(SQLException e){
            Toast.makeText(context, "ERROR DE INSERCION", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /* todo:
         operaciones para actualizar la estructura de la bd (por ejemplo, en el caso de una versión posterior.
         Nos queda como explicación a nivel conceptual. No lo vamos a realizar nosotros
        */
    }
}
