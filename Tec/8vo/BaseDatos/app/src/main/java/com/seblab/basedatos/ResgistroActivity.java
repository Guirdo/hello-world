package com.seblab.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResgistroActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edRFC,etNombre,etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        Button btnRegistro = (Button) findViewById(R.id.btnRegistro);

        edRFC = (EditText) findViewById(R.id.etRFC);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);

        btnRegistro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegistro){
            String rfc = edRFC.getText().toString();
            String nombre = etNombre.getText().toString();
            String telefono = etTelefono.getText().toString();

            if(!rfc.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty()){
                BaseDatos admin = new BaseDatos(this,"BaseDatos",null,1);
                SQLiteDatabase bd = admin.getWritableDatabase();

                ContentValues registro = new ContentValues();
                registro.put("rfc",rfc);
                registro.put("nombre",nombre);
                registro.put("telefono",telefono);

                bd.insert("usuario",null,registro);
                bd.close();

                edRFC.setText("");
                etNombre.setText("");
                etTelefono.setText("");

                Toast.makeText(this,"Datos almacenados",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"Campos vacios",Toast.LENGTH_LONG).show();
            }
        }
    }
}
