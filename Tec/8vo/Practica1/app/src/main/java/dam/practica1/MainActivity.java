package dam.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre,ap,am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.nombre);
        ap = (EditText)findViewById(R.id.apePat);
        am = (EditText)findViewById(R.id.apeMat);
        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nom = nombre.getText().toString();
        String apePat = ap.getText().toString();
        String apeMat = am.getText().toString();

        Persona persona = new Persona(nom,apePat,apeMat);
    }
}
