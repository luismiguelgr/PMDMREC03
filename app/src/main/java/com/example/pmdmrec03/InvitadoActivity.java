package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
    ListView listview;
    ArrayList<Provincia> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        dbHelper = new MyOpenHelper(this);
        db = dbHelper.getWritableDatabase();

        spinnerUsuarios = (Spinner) findViewById(R.id.spinnerInvitadoUsuarios);
        listview = (ListView) findViewById(R.id.listViewInvitado);


         lista = new ArrayList<Provincia>();
        Cursor c = db.rawQuery("SELECT * FROM provincias ", null);

        if (c.moveToFirst()) {

            while (!c.isAfterLast()) {
                String nombre = c.getString(c.getColumnIndex("nombre"));
                String fase = c.getString(c.getColumnIndex("fase"));
                lista.add(new Provincia(nombre, fase));
                c.moveToNext();
            }
        }
        ArrayAdapter<Provincia> adapter = new ArrayAdapter<Provincia>(this, android.R.layout.simple_list_item_1, lista);

        listview.setAdapter(adapter);

        list = new ArrayList<String>(Arrays.asList("111,222,333,444,555,666".split(",")));
        listview.setAdapter(new MyCustomAdapter(list, context) );


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(InvitadoActivity.this, "Has pulsado: "+ lista.get(position), Toast.LENGTH_LONG).show();
            }
        });
        //ArrayAdapter<Provincia> adapter = new ArrayAdapter<Provincia>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, lista);
        //adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        //spinnerUsuarios.setAdapter(adapter);
    }
}
