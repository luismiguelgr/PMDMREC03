package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import sqlite.MyOpenHelper;
import sqlite.Provincia;

public class InvitadoActivity extends AppCompatActivity {

    private MyOpenHelper dbHelper;
    SQLiteDatabase db;
    ListView listView;
    ArrayList<Provincia> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        listView = (ListView) findViewById(R.id.listViewInvitado);


        lista = new ArrayList<Provincia>();
        Cursor c = db.rawQuery("SELECT * FROM provincias ", null);

        if (c.moveToFirst()) {

            while (!c.isAfterLast()) {
                String nombre = c.getString(c.getColumnIndex("nombre"));
                int fase = c.getInt(c.getColumnIndex("fase"));

                lista.add(new Provincia(nombre, fase));
                c.moveToNext();
            }
        }

        MyAdapter myAdapter = new MyAdapter(this, R.layout.lista_provincias, lista);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(InvitadoActivity.this, "Has pulsado: "+ lista.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}


