package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class LugoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugo);

        TextView textLugo = (TextView) findViewById(R.id.textLugo);
        TextView descripcionLugo = (TextView) findViewById(R.id.descripcionLugo);
        descripcionLugo.setMovementMethod(new ScrollingMovementMethod());

        String fase = getIntent().getStringExtra("fase");
        String descripcion = getIntent().getStringExtra("descripcion");
        descripcionLugo.setText("Fase: "+fase+":\n "+descripcion);

    }
}
