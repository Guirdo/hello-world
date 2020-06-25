package com.seblab.cambiosactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        Button btnInvocar = (Button) findViewById(R.id.btnInvocar);
        Button btnPasar = (Button) findViewById(R.id.btnPasar);

        btnInvocar.setOnClickListener(this);
        btnPasar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnInvocar){
            startActivity(new Intent(this,UnoActividad.class));
        }else if(v.getId() == R.id.btnPasar){
            String nombre = edtNombre.getText().toString();
            if(!nombre.isEmpty()){
                Intent intent = new Intent(this,DosActividad.class);
                intent.putExtra("nombre",nombre);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Nombre vacio",Toast.LENGTH_LONG).show();
            }
        }
    }
}
