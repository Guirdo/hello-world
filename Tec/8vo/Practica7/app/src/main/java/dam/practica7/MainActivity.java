package dam.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button boton;
    private ArrayList<String> imgs;
    private ArrayList<Item> items;
    private ListView listview;
    private EditText txtP1;
    private android.content.Context context;
    private ArrayList<String> names;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        txtP1 = (EditText) findViewById(R.id.editText);
        names = new ArrayList<String>();
        imgs = new ArrayList<String>();
        items =new ArrayList<Item>();

        sp = findViewById(R.id.spinner);
        sp.setVisibility(View.VISIBLE);

        String materias[] = new String[8];
        materias[0]="Aplicaciones moviles";
        materias[1]="Programacion web";
        materias[2]="Base de datos II";
        materias[3]="Estructura de datos";
        materias[4]="Programacion oo I";
        materias[5]="Aplicaciones en la nube";
        materias[6]="Programacion en lenguaje ensamblador";
        materias[7]="Inteligencia Artificial";
//cargamos
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, materias);
        sp.setAdapter(adapter);
//agregando el evento para seleccionar
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long
                    l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),selected, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new HTTPReqTask().execute(
                "http://sistematizaciongro.com.mx/push/webservice1.php" );
    }

    private class HTTPReqTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... urls) {
            StringBuilder stringBuilder = new StringBuilder();
            HttpURLConnection urlConnection = null;
            try {
                JSONObject postData = new JSONObject();
                postData.put("us", txtP1.getText().toString());
                URL url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);
                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                        out, "UTF-8"));
                writer.write(postData.toString());
                writer.flush();
                int code = urlConnection.getResponseCode();
                if (code != 200) {
                    throw new IOException("Invalid response from server: " + code);
                }
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    Log.i("data", line);
                    stringBuilder.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return stringBuilder.toString();
        }
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray OJson = jsonObject.getJSONArray("items");
                String campo1="";
//recorremos el arreglo
                ArrayList<String> list_sp = new ArrayList<String>();
                for (int i = 0; i < OJson.length(); i++) {
                    JSONObject c = OJson.getJSONObject(i);
                    String tit = c.getString("titulo");
                    String img = c.getString("imagen");
                    String des = c.getString("descripcion");
// campo1 = campo1 + tit + "\n"; names.add(tit);
// imgs.add(img);
                    items.add(new Item(tit,des,img));
                    Log.i("titulo", tit);
                }
                adapterSpinner dataAdapter = new adapterSpinner(context,items);
                sp.setAdapter(dataAdapter);
                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i,
                                               long l) {
                        String selected = items.get(i).titulo;
                        Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
//ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1, list_sp);
//sp.setAdapter(adapter);
            } catch (Exception e) {
                Log.d("error adapter", "" + e );
            }
        }
    }
}
