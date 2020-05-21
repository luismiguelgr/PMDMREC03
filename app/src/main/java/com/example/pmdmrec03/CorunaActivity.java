package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class CorunaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coruna);

        TextView descripcionCoruna = (TextView) findViewById(R.id.descripcionCoruna);
        descripcionCoruna.setMovementMethod(new ScrollingMovementMethod());

        String fase = getIntent().getStringExtra("fase");
        String descripcion = getIntent().getStringExtra("descripcion");
        descripcionCoruna.setText("Fase: "+fase+":\n "+descripcion);

    }
}
