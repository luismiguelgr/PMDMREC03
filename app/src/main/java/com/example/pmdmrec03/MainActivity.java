package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sqlite.BaseDatos;
import sqlite.Usuario;

public class MainActivity extends AppCompatActivity {

    private BaseDatos bd;
    Button  btnInvitado;
    Button  btnAdmin;
    Button  btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInvitado = (Button) findViewById(R.id.buttonInvitado);
        btnAdmin = (Button) findViewById(R.id.buttonAdmin);
        btnRegistro = (Button) findViewById(R.id.buttonRegistro);

        btnInvitado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario(1, "miguel", "abc");
                bd.insertar(u.getUsuario(), u.getContrasena());
                Toast.makeText(getApplicationContext(),"Has entrado como invitado", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Has entrado como administrador", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Has entrado ara registrarte", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
