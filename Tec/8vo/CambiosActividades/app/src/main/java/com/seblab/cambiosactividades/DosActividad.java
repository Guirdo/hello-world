package com.seblab.cambiosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DosActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos_actividad);

        TextView tvSaludo = (TextView) findViewById(R.id.tvSaludo);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");

        tvSaludo.setText("¡Hola "+nombre+"!");
    }
}
