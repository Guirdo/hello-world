package com.seblab.ejemplocalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int num1,num2;
    private TextView txtResultado;
    private EditText edtNum1,edtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText) findViewById(R.id.num1);
        edtNum2 = (EditText) findViewById(R.id.num2);

        txtResultado = (TextView) findViewById(R.id.txtRes);
    }

    public void manejaEventoDivision() {
        int resu = num1 / num2;

        txtResultado.setText("" + resu);
    }

    public void manejaEventoMultiplicacion() {
        int resu = num1 * num2;

        txtResultado.setText("" + resu);
    }

    public void manejaEventoResta() {
        int resta = num1 - num2;

        txtResultado.setText("" + resta);
    }

    public void manejaEventoSuma(){
        int suma = num1+num2;

        txtResultado.setText(""+suma);
    }

    @Override
    public void onClick(View v) {
        try{
            num1 = Integer.parseInt(edtNum1.getText().toString());
            num2 = Integer.parseInt(edtNum2.getText().toString());
            if(v.getId() == R.id.btnSuma){
                manejaEventoSuma();
            }else if(v.getId() == R.id.btnResta){
                manejaEventoResta();
            }else if(v.getId() == R.id.btnMul){
                manejaEventoMultiplicacion();
            }else if(v.getId() == R.id.btnDiv){
                manejaEventoDivision();
            }
        }catch (NumberFormatException e){
            Toast.makeText(this, "Estas mal compa!", Toast.LENGTH_SHORT).show();
        }
    }
}
