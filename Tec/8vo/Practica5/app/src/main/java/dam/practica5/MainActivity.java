package dam.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<String> imgs;
    private ArrayList<String> names;
    private ArrayList<Item> items;
    private ListView listview;

    EditText txtP1;
    TextView txtresp;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        txtP1 = (EditText) findViewById(R.id.editText);
        txtresp = (TextView) findViewById(R.id.textViewresp);
        listview = (ListView) findViewById(R.id.listView);
        Button boton = (Button) findViewById(R.id.button);
        items =new ArrayList<Item>();

        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new leeJSONPOST().execute(
                "http://sistematizaciongro.com.mx/push/webservice1.php" );
    }

    private class leeJSONPOST extends AsyncTask<String, String, String> {
        protected String doInBackground(String... urls) {
            return readJSON_Post(urls[0]);
        }
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray OJson = jsonObject.getJSONArray("items");
                String campo1="";
                //recorremos el arreglo
                for (int i = 0; i < OJson.length(); i++) {
                    JSONObject c = OJson.getJSONObject(i);
                    String tit = c.getString("titulo");
                    String img = c.getString("imagen");
                    String des = c.getString("descripcion");
                    campo1 = campo1 + tit + "\n";
                    names.add(tit);
                    imgs.add(img);
                    items.add(new Item(tit,des,img));
                }
                myAdapter myAdapter = new myAdapter(context, R.layout.list_item,
                        names,imgs,items);
                listview.setAdapter(myAdapter);
            } catch (Exception e) {
                Log.d("error adapter", "" + e );
// Log.d("JSON", "error en datosssss");
                txtresp.setText("error en datos..post..");
            }
        }
        public String readJSON_Post(String URL) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                HttpClient httpclient = new DefaultHttpClient();
/*Creamos el objeto de HttpClient que nos permitira conectarnos
mediante peticiones http*/
                HttpPost httppost = new HttpPost(URL);
/*El objeto HttpPost permite que enviemos una peticion de tipo POST a
una URL especificada*/
//AÑADIR PARAMETROS
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("us", txtP1.getText().toString()));
/*Una vez añadidos los parametros actualizamos la entidad de
httppost, esto quiere decir en pocas palabras anexamos los parametros al objeto
para que al enviarse al servidor envien los datos que hemos añadido*/
                httppost.setEntity(new UrlEncodedFormEntity(params));
                /*Finalmente ejecutamos enviando la info al server*/
                HttpResponse resp = httpclient.execute(httppost);
                StatusLine statusLine = resp.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                if (statusCode == 200) {
                    HttpEntity entity = resp.getEntity();
                    InputStream inputStream = entity.getContent();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(inputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    inputStream.close();
                    Log.d("JSON:---->", stringBuilder.toString());
// txtres.setText(stringBuilder.toString());
                } else {
                    Log.d("JSON", "Failed to download file");
                }
            } catch (Exception e) {
                Log.d("readJSONFeed", e.getLocalizedMessage());
            }
            return stringBuilder.toString();
        }
    }
}
