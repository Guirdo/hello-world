package dam.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mensaje;
    TextView servidorMsg;
    String miMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = (EditText) findViewById(R.id.mensaje);
        servidorMsg = (TextView) findViewById(R.id.servidorMsg);
        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        miMensaje = mensaje.getText().toString();
        new sock().execute();
    }

    private class sock extends AsyncTask<String, Integer, String> {
        Socket socket;

        @Override
        protected void onPreExecute() {
        }

        protected String doInBackground(String... urls) {
            String datoServer="";
            try {
                socket = new Socket("192.168.0.7", 5000);
                DataInputStream input1 = new DataInputStream(socket.getInputStream());
                DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());
                salidaCliente.writeUTF(miMensaje);
                datoServer= input1.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datoServer;
        }

        protected void onPostExecute(String result) {
            servidorMsg.setText(result);
        }
    }
}
