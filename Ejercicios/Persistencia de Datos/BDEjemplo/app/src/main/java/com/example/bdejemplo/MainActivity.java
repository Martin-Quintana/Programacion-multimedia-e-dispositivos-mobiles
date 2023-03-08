package com.example.bdejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String strDatabaseName = "DB_Alumnos";
    private SQLiteDatabase sqLiteDatabase; //objeto DB propiamente dicho

    /* ================================================================================
       ATENCION!!!!!
       En este ejemplo, donde todas las operaciones se ejecutan en la misma activity,
       ¿dónde podríamos cerrar la base de datos como fin de ejecución con la misma?
     ================================================================================== */


    private TextView txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensaje = findViewById(R.id.txtMensaje);

        /* Generamos una instancia de la clase auxiliar que hemos creado (heredada de SQLiteOpenHelper)
        En la 1ª llamada al constructor, se crea la BD.
        En sucesivas ejecuciones, como la BD ya existe, no se ejecutará el método onCreate
        (public void onCreate(SQLiteDatabase sqLiteDatabase) {...}
        con la consiguiente inexistencia de posibles conflictos. */
        SQLiteOpenHelper sqLiteOpenHelper =
                new SQLiteOpenHelper(this, strDatabaseName, null, 1);

        /* Sea la primera ejecución de nuestra app o sea en ejecuciones siguientes, llegados aquí la BD
        ya existe. Procedemos ahora a su apertura con el método correspondiente:
        getReadableDatabase() o getWritableDatabase()
         */
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();

    }//end onCreate

    /*=============   listener de los botones en donde he incluído todas las operaciones para que
                       se vea su funcionamiento                                ================== */
    public void onClickBtn(View view) {
        switch (view.getId()) {

            case R.id.btnInsertarSQL:
                //insercion directa (no recomendable, pero para que se vea su funcionalidad
                try {
                    sqLiteDatabase.execSQL("INSERT INTO Alumnos (codigo, nombre) VALUES (3, 'Juan de Juanes')");
                    sqLiteDatabase.execSQL("INSERT INTO Alumnos (codigo, nombre) VALUES (4, 'Pepe de Pepes')");
                    sqLiteDatabase.execSQL("INSERT INTO Alumnos (codigo, nombre) VALUES (5, 'Laura de Lauras')");
                } catch (SQLException e) {
                    txtMensaje.setText("ERROR de inserción directa");
                }
                break;

            case R.id.btnInsertarParametrizado:
                /* =============     insercion con método insert() --> recomendable
                                     Necesitamos usar un objeto ContentValues  ===== */
                ContentValues registroNuevo = new ContentValues();
                registroNuevo.put("codigo", 1);
                /* repito el valor 1 para el código A PROPÓSITO, para que se vea que la ejecución NO ROMPE
                   (aunque se pueda ver mensaje en el archivo de Log) pese a que no capturo la excepción de
                   forma explícita (como en la inserción directa, con try-catch
                 */
                registroNuevo.put("nombre", "Ana");
                long l = sqLiteDatabase.insert("Alumnos", null, registroNuevo);
                if (l == -1) { // no se ha producido la inserción y puedo testearlo y hacer lo que corresponda...
                    txtMensaje.setText("ERROR en método insert: el codigo 1 ya existe");
                } else {
                    txtMensaje.setText("Inserción correcta con insert()");
                }
                break;

            case R.id.btnEliminarSQL:
                //eliminación directa (no recomendable, pero para que se vea su funcionalidad)
                sqLiteDatabase.execSQL("DELETE FROM Alumnos WHERE codigo=1");
                break;

            case R.id.btnEliminarParametrizado:
                //eliminación con método específico: delete()  --> opción recomendable
                int delete = sqLiteDatabase.delete("Alumnos", "codigo=2", null);
                if (delete != 0) { // no se ha producido el borrado y puedo testearlo y hacer lo que corresponda...
                    txtMensaje.setText("Eliminación correcta con delete: código 2 borrado");
                } else {
                    txtMensaje.setText("ERROR en el método delete: el codigo 2 NO existe");
                }
                /* =========  en este ejemplo tan simple, en este momento ya no tendré ninuno de los registros
                              que inserté en el método onCreate de la clase auxiliar  ======================== */
                break;

            case R.id.btnModificarSQL:
                //modificacion directa (no recomendable, pero para que se vea su funcionalidad)
                sqLiteDatabase.execSQL("UPDATE Alumnos SET nombre='Eva sustituye a Juan de Juanes' WHERE codigo=3");
                break;

            case R.id.btnModificarParametrizado:
               /* =============     modificación con método update() --> recomendable
                                    Necesitamos usar un objeto ContentValues  ===== */
                ContentValues nuevosValoresParaRegistro = new ContentValues();
                nuevosValoresParaRegistro.put("nombre", "Margarita sustituye a Pepe de Pepes");
                int update = sqLiteDatabase.update("Alumnos", nuevosValoresParaRegistro, "codigo=4", null);
                if (update == -1) { // no se ha producido la modificación y puedo testearlo y hacer lo que corresponda...
                    txtMensaje.setText("ERROR en el método update: el codigo 4 NO existe");
                } else {
                    txtMensaje.setText("update() correcto: 4.Pepe se llama ahora Margarita");
                }
                break;

            case R.id.btnMostrar1SQL:
                /* busqueda directa (no recomendable, pero para que se vea su funcionalidad)
                   Como comenté antes, en este caso no sirve el método execSQL().
                   Usamos en su lugar rawQuery() */
                Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT nombre FROM Alumnos WHERE codigo=1", null);
                if (cursor1.moveToFirst()) {
                    String nombre = cursor1.getString(0);//dato que recupero en la pos. 0 (y única) de mi SELECT
                    txtMensaje.setText("rawQuery() recuperó a " + nombre + " con el código 1");
                } else {
                    txtMensaje.setText("rawQuery() error: no existe código 1");
                }
                cursor1.close();  //siempre hay que cerrar el cursor...
                break;

            case R.id.btnMostrar1Parametrizado:
                /* =============    búsqueda con método específico: query() --> recomendable  ===== */
                String[] datos = {"nombre"};
                Cursor cursor1Bis = sqLiteDatabase.query("Alumnos", datos, "codigo=4",
                        null, null, null, null, null);
                if (cursor1Bis.moveToFirst()) {
                    String nombre = cursor1Bis.getString(0);//0 pq en SELECT solo recupero un dato=nombre
                    txtMensaje.setText("query() recuperó a " + nombre + " con el código 4");
                } else {
                    txtMensaje.setText("query() error: no existe código 4");
                }
                cursor1Bis.close(); //siempre hay que cerrar el cursor...
                break;

            case R.id.btnMostrarNSQL:
                 /* busqueda directa (no recomendable, pero para que se vea su funcionalidad)
                   Como comenté antes, en este caso no sirve el método execSQL().
                   Usamos en su lugar rawQuery() */
                Cursor cursor2 = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos", null);
                if (cursor2.moveToFirst()) {//o cualquier otra forma válida de búsqueda en bucle...
                    txtMensaje.setText("Consulta directa:");
                    do {
                        int codigo = cursor2.getInt(0);//campo1 --> codigo
                        String nombre = cursor2.getString(1);//campo2 --> nombre
                        txtMensaje.append("\nCódigo: " + codigo + " Nombre: " + nombre);
                    } while (cursor2.moveToNext());
                } else
                    txtMensaje.setText("Consulta directa: NO EXISTEN DATOS");
                cursor2.close();//siempre hay que cerrar el cursor...
                break;

            case R.id.btnMostrarNParametrizado:
                //busqueda mediante método específico
                String[] datosARecuperar = {"codigo", "nombre"};
                Cursor cursor3Bis = sqLiteDatabase.query("Alumnos", datosARecuperar, null,
                        null, null, null, null, null);
                if (cursor3Bis.moveToFirst()) {
                    txtMensaje.setText("Consulta parametrizada:");
                    do {
                        int codigo = cursor3Bis.getInt(0);//campo1 --> codigo
                        String nombre = cursor3Bis.getString(1);//campo2 --> nombre
                        txtMensaje.append("\nCódigo: " + codigo + " Nombre: " + nombre);
                    } while (cursor3Bis.moveToNext());
                } else
                    txtMensaje.setText("Consulta directa: NO EXISTEN DATOS");
                cursor3Bis.close();//siempre hay que cerrar el cursor...
                break;
                }
    }//end onClickBtn

}//end MainActivity