package edu.itch.guirdo.consultapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;

public class MainActivity extends Activity {

    private EditText edDic;
    private EditText edBD;
    private EditText edUser;
    private EditText edContra;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDic=findViewById(R.id.edDireccion);
        edBD=findViewById(R.id.edBD);
        edUser=findViewById(R.id.edUsuario);
        edContra=findViewById(R.id.edPW);
        btnIngresar=findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String direccion = edDic.getText().toString();
                String bd=edBD.getText().toString();
                String user = edUser.getText().toString();
                String contra = edContra.getText().toString();
                String url= "jdbc:mysql://"+direccion+":3306/"+bd;

                try {
                    Conexion con = new Conexion(url,user,contra);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
