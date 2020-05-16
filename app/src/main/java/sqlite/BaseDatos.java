package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    public final static String NOMBRE_BD="PMDMREC03";
    public final static int VERSION_BD=1;
    private SQLiteDatabase consultas;

    private String CREAR_TABLA_USUARIOS ="CREATE TABLE usuarios (id  INTEGER PRIMARY KEY AUTOINCREMENT, usuario VARCHAR(50) NOT NULL, contrasena VARCHAR(40) NOT NULL)";

    public BaseDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public void setSQLiteDatabase(SQLiteDatabase consultas){
        this.consultas = consultas;
    }
}
