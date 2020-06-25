package com.seblab.ejemplosesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtUsuario,edtContrasena;
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtContrasena = (EditText) findViewById(R.id.edtContrasena);
        btnLogIn = (Button) findViewById(R.id.btnConectr);
        btnLogIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent welcomeActivity = new Intent(this,WelcomeActivity.class);
        Bundle datos = new Bundle();

        datos.putString("usuario",edtUsuario.getText().toString());
        welcomeActivity.putExtras(datos);

        startActivity(welcomeActivity);
    }
}
