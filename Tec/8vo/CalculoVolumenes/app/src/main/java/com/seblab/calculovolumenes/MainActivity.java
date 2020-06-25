package com.seblab.calculovolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnEsfera,btnPiramide,btnCubo,btnCilindro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEsfera = (Button) findViewById(R.id.btnEsfera);
        btnCubo = (Button) findViewById(R.id.btnCubo);
        btnPiramide = (Button) findViewById(R.id.btnPiramide);
        btnCilindro = (Button) findViewById(R.id.btnCilindro);

        //OnClickListener
        btnEsfera.setOnClickListener(this);
        btnPiramide.setOnClickListener(this);
        btnCubo.setOnClickListener(this);
        btnCilindro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnEsfera){
            startActivity(new Intent(this,VolumenEsferaActivity.class));
        }else if(v.getId()==R.id.btnPiramide){
            startActivity(new Intent(this,VolumenPiramideActivity.class));
        }else if(v.getId()==R.id.btnCubo){
            startActivity(new Intent(this,VolumenCuboActivity.class));
        }else if(v.getId()==R.id.btnCilindro){
            startActivity(new Intent(this,VolumenPiramideActivity.class));
        }
    }
}
