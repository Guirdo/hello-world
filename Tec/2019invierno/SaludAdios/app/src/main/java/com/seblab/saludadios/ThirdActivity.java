package com.seblab.saludadios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Button btnProcesar;
    private Button btnCompatir;
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnProcesar = findViewById(R.id.btnProcesar);
        btnCompatir = findViewById(R.id.btnCompartir);
        btnCompatir.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String nombre = bundle.getString("nombre");
            int edad = bundle.getInt("edad");
            int opcion = bundle.getInt("opcion");

            if(opcion == SecondActivity.GREETING_CODE){
                mensaje="Hola "+nombre+" ¿Cómo te ha ido durante estos "+edad+" años en la tierra? #MyForm";
            }else{
                mensaje="Hasta luego "+nombre+". Espero volver a verte cuando cumplas "+(edad+1)+" años #MyForm";
            }
        }

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCompatir.setVisibility(View.VISIBLE);
                btnProcesar.setVisibility(View.INVISIBLE);
                Toast.makeText(ThirdActivity.this,mensaje,Toast.LENGTH_LONG).show();
            }
        });

        btnCompatir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,mensaje);
                startActivity(intent);
            }
        });

    }
}
