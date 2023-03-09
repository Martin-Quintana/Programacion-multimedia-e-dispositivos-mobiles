package com.example.examen_final;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public static final String strCreateTable = "CREATE TABLE compuestos (nombre TEXT PRIMARY KEY, formula TEXT)";

    Context context;

    public SQLiteOpenHelper(@Nullable Context context,
                            @Nullable String nameOfDatabase,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, nameOfDatabase, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(strCreateTable);
        try {
            sqLiteDatabase.execSQL("INSERT INTO compuestos (nombre, formula) VALUES ('Agua', 'H2O')");
            sqLiteDatabase.execSQL("INSERT INTO compuestos (nombre, formula) VALUES ('Acido Clorhidrico', 'HCl')");
            sqLiteDatabase.execSQL("INSERT INTO compuestos (nombre, formula) VALUES ('Acido Nitrico', 'HNO3')");
            sqLiteDatabase.execSQL("INSERT INTO compuestos (nombre, formula) VALUES ('Acido Sulfurico', 'H2SO4')");
            sqLiteDatabase.execSQL("INSERT INTO compuestos (nombre, formula) VALUES ('Acido Acetico', 'CH3COOH')");
        } catch (SQLException e) {
            Toast.makeText(context, "ERROR DE INSERCION", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
