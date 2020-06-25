package com.seblab.calculovolumenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VolumenEsferaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtRadio;
    Button btnCalcular,btnRegresar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_esfera);

        edtRadio = (EditText) findViewById(R.id.radioEsfera);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcularEsf);
        btnRegresar = (Button) findViewById(R.id.btnRegresarEsf);

        btnCalcular.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnCalcularEsf){
            calcularVolumen();
        }else if(v.getId() == R.id.btnRegresarEsf){
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void calcularVolumen(){
        if(!edtRadio.getText().toString().isEmpty()){
            double radio = Double.parseDouble(edtRadio.getText().toString());

            double resultado = (4*Math.PI*Math.pow(radio,3))/3;
            txtResultado.setText(String.valueOf(resultado));
        }else{
            Toast.makeText(this, "Ingrese valores numericos validos", Toast.LENGTH_LONG).show();
        }

    }
}
