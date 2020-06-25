package dam.proyecto2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static int CODIGO = 1;
    EditText dato1,dato2;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dato1 = (EditText) findViewById(R.id.dato1);
        dato2 = (EditText) findViewById(R.id.dato2);
        resultado = (TextView) findViewById(R.id.resultado);

        Button boton1 = (Button) findViewById(R.id.boton1);

        boton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Actividad2.class);
        Bundle bundle = new Bundle();

        String dat1 = dato1.getText().toString();
        String dat2 = dato2.getText().toString();
        bundle.putString("dato1", dat1);
        bundle.putString("dato2", dat2);

        intent.putExtras(bundle);
        startActivityForResult(intent,CODIGO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_CANCELED){
            Bundle bundle = data.getExtras();

            String resul = bundle.getString("resultado");

            resultado.setText(resul);
        }
    }
}
