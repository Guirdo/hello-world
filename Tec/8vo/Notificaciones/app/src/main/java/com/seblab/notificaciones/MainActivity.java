package com.seblab.notificaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPulsame = (Button) findViewById(R.id.btnPulsame);
        btnPulsame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnPulsame){
            Toast.makeText(this,"¡Me has pulsado!",Toast.LENGTH_LONG).show();
        }
    }
}
