package com.example.pmdmrec03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class OurenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourense);

        TextView descripcionOurense = (TextView) findViewById(R.id.descripcionOurense);
        descripcionOurense.setMovementMethod(new ScrollingMovementMethod());

        String fase = getIntent().getStringExtra("fase");
        String descripcion = getIntent().getStringExtra("descripcion");
        descripcionOurense.setText("Fase: "+fase+":\n "+descripcion);
    }
}
