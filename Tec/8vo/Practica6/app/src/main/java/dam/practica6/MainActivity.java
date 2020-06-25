package dam.practica6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

    public RecyclerView rv;
    AdapterRecycler mAdapter;
    private ArrayList<String> imgs;
    private ArrayList<Item> items;
    private ListView listview;
    private EditText txtP1;
    private android.content.Context context;
    private ArrayList<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        txtP1 = (EditText) findViewById(R.id.editText);
        rv = (RecyclerView) findViewById(R.id.myRecyclerview);
        Button btnPost = findViewById(R.id.button);
        names = new ArrayList<String>();
        imgs = new ArrayList<String>();
        items =new ArrayList<Item>();
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
//txtresp.setText(tit);
                    campo1 = campo1 + tit + "\n";
                    names.add(tit);
                    imgs.add(img);
                    items.add(new Item(tit,des,img));
                }
                rv.setHasFixedSize(true);
// use a linear layout manager
                rv.setLayoutManager(new LinearLayoutManager(context));
// specify an adapter with the list to show
                mAdapter = new AdapterRecycler(items,context);
                rv.setAdapter(mAdapter);
            } catch (Exception e) {
                Log.d("error adapter", "" + e );
            }
        }
        public String readJSON_Post(String URL) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(URL);
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("us",
                        txtP1.getText().toString()));
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
