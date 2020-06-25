package com.seblab.calculovolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VolumenCilindroActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCalcular,btnRegresar;
    TextView txtResultadoCil;
    EditText edtRadio,edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cilindro);

        btnCalcular = (Button) findViewById(R.id.btnCalcularCil);
        btnRegresar = (Button) findViewById(R.id.btnRegresarCil);
        edtRadio = (EditText) findViewById(R.id.edtRadioCil);
        edtAltura = (EditText) findViewById(R.id.edtAlturaCil);
        txtResultadoCil = (TextView) findViewById(R.id.txtResultadoCil);

        btnCalcular.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalcularCil){
            calcularVolumen();
        }else if(v.getId() == R.id.btnRegresarCil){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void calcularVolumen() {
        if(!edtRadio.getText().toString().isEmpty() && !edtAltura.getText().toString().isEmpty()){
            double radio = Double.parseDouble(edtRadio.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());

            double resultado = Math.PI*Math.pow(radio,2)*altura;
            txtResultadoCil.setText(String.valueOf(resultado));
        }else{
            Toast.makeText(this, "Ingrese valores numericos validos", Toast.LENGTH_LONG).show();
        }

    }
}
