package sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

    public final static String NOMBRE_BD="basedatos";
    public final static int VERSION_BD=1;
    private SQLiteDatabase db;

    // CREATES
    private String CREAR_TABLA_PROVINCIAS = "CREATE TABLE provincias (id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , nombre VARCHAR(50) NOT NULL, fase INTEGER)";
    private String CREAR_TABLA_USUARIOS = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , usuario VARCHAR(50) NOT NULL, contrasena VARCHAR(40) NOT NULL, nombre VARCHAR(100) NOT NULL, apellidos VARCHAR(150), email VARCHAR(200))";
    // INSERTS
    private String INSERTAR_DATOS_USUARIOS = "INSERT INTO usuarios (usuario, contrasena) VALUES ('miguel', 'abc')";
    private String INSERTAR_DATOS_PROVINCIAS = "INSERT INTO provincias (nombre, fase) VALUES ('Lugo', 1), ('Ourense', 0), ('A Coruña', 2), ('Pontevedra', 0)";

    public MyOpenHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    public void setSQLiteDatabase(SQLiteDatabase db){
        this.db = db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIOS);
        db.execSQL(CREAR_TABLA_PROVINCIAS);
        //db.execSQL(INSERTAR_DATOS_USUARIOS);
        db.execSQL(INSERTAR_DATOS_PROVINCIAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS provincias");
        onCreate(db);
    }

    public void insertarUsuario(String usuario,String contrasena){
        //db.execSQL("INSERT INTO usuarios (usuario, contrasena) VALUES ('miguel', 'abc')");
        ContentValues cv = new ContentValues();
        cv.put("usuario", usuario);
        cv.put("contrasena", contrasena);
        db.insert("usuarios", null, cv);
    }


}
