package com.seblab.calculovolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VolumenPiramideActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtAltura,edtLado;
    Button btnCalcular,btnRegresar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_piramide);

        edtAltura = (EditText) findViewById(R.id.edtAlturaPir);
        edtLado = (EditText) findViewById(R.id.edtLadoPira);
        btnCalcular = (Button) findViewById(R.id.btnCalcularPir);
        btnRegresar = (Button) findViewById(R.id.btnRegresarPir);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnCalcularPir){
            calcularVolumen();
        }else if(v.getId()==R.id.btnRegresarPir){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void calcularVolumen() {
        if(!edtLado.getText().toString().isEmpty() && !edtAltura.getText().toString().isEmpty()){
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double lado = Double.parseDouble(edtLado.getText().toString());
            double resultado = (Math.pow(lado,2)*altura)/3;
            txtResultado.setText(String.valueOf(resultado));
        }else{
            Toast.makeText(this, "Ingrese valores numericos validos", Toast.LENGTH_LONG).show();
        }

    }
}
