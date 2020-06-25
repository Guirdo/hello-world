package com.seblab.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        Button btnVer = (Button) findViewById(R.id.btnVer);

        btnRegistrar.setOnClickListener(this);
        btnVer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegistrar){
            startActivity( new Intent(this,ResgistroActivity.class));
        }else if(v.getId() == R.id.btnVer){
            startActivity( new Intent(this,VisualizarActivity.class));
        }
    }
}
