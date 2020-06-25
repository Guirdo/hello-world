package com.seblab.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VisualizarActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvNombre,tvTelefono;
    EditText etRFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        Button btnConsultar = (Button) findViewById(R.id.btnConsultar);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        etRFC = (EditText) findViewById(R.id.etRFC1);

        btnConsultar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnConsultar){
            String rfc = etRFC.getText().toString();
            if(!rfc.isEmpty()){
                BaseDatos admin = new BaseDatos(this,"BaseDatos",null,1);
                SQLiteDatabase bd = admin.getReadableDatabase();

                Cursor fila = bd.rawQuery("select nombre,telefono from usuario where rfc = '"+rfc+"'",null);

                if(fila.moveToFirst()){
                    tvNombre.setText(fila.getString(0));
                    tvTelefono.setText(fila.getString(1));

                    bd.close();
                }else{
                    tvNombre.setText("");
                    tvTelefono.setText("");
                    Toast.makeText(this,"Usuario no encontrado",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"Campo vacio",Toast.LENGTH_LONG).show();
            }
        }
    }
}
