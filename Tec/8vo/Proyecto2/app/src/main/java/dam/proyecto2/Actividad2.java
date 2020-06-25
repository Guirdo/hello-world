package dam.proyecto2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad2 extends AppCompatActivity implements View.OnClickListener{

    EditText dato1,dato2;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        dato1 = (EditText) findViewById(R.id.dato11);
        dato2 = (EditText) findViewById(R.id.dato21);

        intent = getIntent();
        bundle = intent.getExtras();

        dato1.setText(bundle.getString("dato1"));
        dato2.setText(bundle.getString("dato2"));

        Button boton = (Button) findViewById(R.id.boton2);

        boton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String resultado = dato1.getText().toString()+dato2.getText().toString();
        bundle.putString("resultado", resultado);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);

        finish();
    }
}
