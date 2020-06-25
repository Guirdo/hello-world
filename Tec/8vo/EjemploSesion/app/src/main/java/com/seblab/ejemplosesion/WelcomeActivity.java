package com.seblab.ejemplosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView edtBievenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        edtBievenida = (TextView) findViewById(R.id.edtBievenida);
        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("usuario");

        edtBievenida.setText("Bienvenido "+nombre);
    }
}
