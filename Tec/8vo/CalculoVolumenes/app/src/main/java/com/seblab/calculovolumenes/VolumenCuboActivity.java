package com.seblab.calculovolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VolumenCuboActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCalcular,btnRegresar;
    EditText edtLado;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cubo);

        btnCalcular = (Button) findViewById(R.id.btnCalcularEsf);
        btnRegresar = (Button) findViewById(R.id.btnRegresarEsf);
        edtLado = (EditText) findViewById(R.id.edtRadioCil);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnCalcularEsf){
            calcularVolumen();
        }else if(v.getId()==R.id.btnRegresarEsf){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void calcularVolumen(){
        if(!edtLado.getText().toString().isEmpty()){
            double lado = Double.parseDouble(edtLado.getText().toString());

            double resultado = Math.pow(lado,3);
            txtResultado.setText(String.valueOf(resultado));
        }else{
            Toast.makeText(this, "Ingrese valores numericos validos", Toast.LENGTH_LONG).show();
        }

    }
}
