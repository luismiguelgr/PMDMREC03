package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import sqlite.MyOpenHelper;
import sqlite.Provincia;
import sqlite.Usuario;

public class InvitadoActivity extends AppCompatActivity {

    private MyOpenHelper dbHelper;
    SQLiteDatabase db;
    Spinner spinnerUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        spinnerUsuarios = (Spinner) findViewById(R.id.spinnerInvitadoUsuarios);



        ArrayList<Provincia> lista = new ArrayList<Provincia>();
        Cursor c = db.rawQuery("SELECT * FROM provincias ", null);

        if (c.moveToFirst()) {

            while (!c.isAfterLast()) {
                String nombre = c.getString(c.getColumnIndex("nombre"));
                String fase = c.getString(c.getColumnIndex("fase"));
                lista.add(new Provincia(nombre, fase));
                c.moveToNext();
            }
        }


        ArrayAdapter<Provincia> adapter = new ArrayAdapter<Provincia>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, lista);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinnerUsuarios.setAdapter(adapter);
    }
}
