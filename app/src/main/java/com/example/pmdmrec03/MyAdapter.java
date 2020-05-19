package com.example.pmdmrec03;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sqlite.Provincia;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Provincia> names;
    Provincia currentName;
    TextView textView;

    public MyAdapter(Context context, int layout, ArrayList<Provincia> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.lista_provincias, null);
        // Valor actual según la posición

        currentName = names.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        textView = (TextView) v.findViewById(R.id.textListaProvincias);
        textView.setText("Provincia:" + currentName.getNombre());

        Button botonVerMas = (Button) v.findViewById(R.id.imageButtonListaProvincias);
        botonVerMas.setFocusable(false);
        botonVerMas.setClickable(false);
        /*Button botonVerMas = (Button) v.findViewById(R.id.imageButtonListaProvincias);
        botonVerMas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                textView.setText("Provincia:" + currentName.getNombre() + " Fase:" + currentName.getFase());
            }
        });
*/
        //Devolvemos la vista inflada
        return v;
    }
}